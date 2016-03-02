import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Set;

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

    /*Ward follows Alan*/
    public Set<UserDTO> readMessegesFromFile() {
        try {

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
