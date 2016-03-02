import java.util.Set;

/**
 * Created by chris on 2016/03/02.
 */
public class FileParser {
    public static FileParser INSTANCE  = getINSTANCE();

    private static FileParser getINSTANCE(){
        if(INSTANCE== null)
            INSTANCE  = new FileParser();
        return INSTANCE;
    }

    public Set<UserDTO> readUsersFromFile (String pathToFile) {
        return null;
    }

    public Set<UserDTO> readMessegesFromFile (String pathToFile) {
        return null;
    }
}
