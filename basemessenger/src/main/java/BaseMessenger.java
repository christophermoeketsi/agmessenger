import java.util.*;


/**
 * Created by chris on 2016/03/02.
 */
public class BaseMessenger {
    public static BaseMessenger INSTANCE = getINSTANCE();
    private Map<String,UserDTO> cachedUsers = new Hashtable<String, UserDTO>();

    private static BaseMessenger getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new BaseMessenger();
        }
        return INSTANCE;
    }

    public BaseMessenger() {
    }

    public boolean readUsers(String pathToFile) {

        return true;
    }

    public Map<String, UserDTO> getCachedUsers() {
        return cachedUsers;
    }

    public void addUserToCache(UserDTO userDTO) {
        if (getCachedUsers().containsValue(userDTO)) {
            UserDTO cachedUser = getCachedUsers().get(userDTO.getUsername());
            cachedUser.doDeepCopyOfFollers(userDTO);
        } else {
            getCachedUsers().put(userDTO.getUsername(), userDTO);
        }
    }

    public void addUserFromFile(String pathToFile) {
        try {
            List<UserDTO> usersFromFile = FileParser.INSTANCE.readUsersFromFile(pathToFile);
            for (UserDTO userFromFile : usersFromFile) {
                addUserToCache(userFromFile);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
