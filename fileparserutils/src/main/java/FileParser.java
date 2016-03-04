import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by chris on 2016/03/02.
 */


public class FileParser {
    public static FileParser INSTANCE = getINSTANCE();

    private static FileParser getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new FileParser();
        return INSTANCE;
    }

    public List<UserDTO> readUsersFromFile(String pathToFile) {
        try {
            List<UserDTO> allUserDTOs = new AGMessengerList<UserDTO>();
            File file = new File(pathToFile);
            if (file.exists()) {
                int lineNumber = 1;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
                String line = bufferedReader.readLine();
                while (line != null) {
                    List userDTOs = parserUserLine(line, lineNumber);
                    allUserDTOs.addAll(userDTOs);
                    lineNumber++;
                    line = bufferedReader.readLine();
                }
            }
            return allUserDTOs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //This method is used to parse the message file
    public List<MessageDTO> readMessegesFromFile(String messageFilePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(messageFilePath));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public MessageDTO parseMessageLine(String line, int currentLineNumber) {
        try {
            if (LineValidator.INSTANCE.isValidMessageLine(line, currentLineNumber)) {
                int fristIndexOfDeliminator = line.indexOf(">");
                String userName = line.substring(0, fristIndexOfDeliminator).trim();
                String message = line.substring(fristIndexOfDeliminator+1, line.length());
                MessageDTO messageDTO = new MessageDTO(userName, message);
                return messageDTO;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<UserDTO> parserUserLine(String line, int currentLineNumber) {
        List<UserDTO> userDTOList = new AGMessengerList<UserDTO>();
        try {
            if (LineValidator.INSTANCE.isValidUserLine(line, currentLineNumber)) {
                String[] lineArray = line.split("follows");
                String followerName = lineArray[0].trim();
                String userNames = lineArray[1].trim();

                if (userNames.trim().contains(",")) {
                    addMulipleUsers(userNames, followerName, userDTOList);
                } else {
                    UserDTO currentUser = new UserDTO(userNames.trim());
                    currentUser.addFollower(new UserDTO(followerName.trim()));
                    userDTOList.add(currentUser);
                    userDTOList.add(new UserDTO(followerName)); //This is also to add the follower as user
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userDTOList;
    }

    private void addMulipleUsers(String userNames, String followerName, List<UserDTO> userDTOList) {
        String[] usersNamesArray = userNames.split(",");
        userDTOList.add(new UserDTO(followerName)); //This is to add the follower as a user
        for (String userName : usersNamesArray) {
            if (userName.trim().length() != 0) {
                UserDTO currentUser = new UserDTO(userName.trim());
                currentUser.addFollower(new UserDTO(followerName.trim()));
                userDTOList.add(currentUser);
            }
        }
    }
}
