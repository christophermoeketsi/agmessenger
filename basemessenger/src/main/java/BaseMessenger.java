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

    public  Map<String,UserDTO> getCachedUsers (){
        return cachedUsers;
    }

    public void printCache(){
        for(String userName  : cachedUsers.keySet()) {
            System.out.println("@" + userName);
            for (MessageDTO messageDTO : cachedUsers.get(userName).getMessages()) {
                System.out.println("\t @"  + messageDTO.getUserName() + " " + messageDTO.getMessage());
            }
        }
    }
}
