import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public Set<UserDTO> readUsersFromFile(String pathToFile) {
        try {
            File file = new File(pathToFile);
            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
                String line = bufferedReader.readLine();
                while (line != null) {

                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /*Ward follows Alan*/
    public Set<UserDTO> readMessegesFromFile() {
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void parserUserLine(String line, int currentLineNumber) {
        try {
            String[] lineArray = line.trim().split("follows");
            if (lineArray.length != 2 || line.trim().indexOf("follows") == -1)
                throw new LineFormatException("There was an error reading line " +
                        line + ": Line number " + currentLineNumber +
                        "Lines should be of the form Ward follows Alan"
                );
            UserDTO userDTO = new UserDTO(lineArray[1]);
            userDTO.addFollower(new UserDTO(lineArray[0]));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
