import java.util.Hashtable;

/**
 * Created by chris on 2016/03/05.
 */
public class Mian {

    public static void main(String args[]) {

        try {
            String pathToUserFile = "";
            String pathToMessageFile = "";
            boolean userFileCommandFound = false;
            boolean messageFileCommandFound = false;
            for (int commandIndex = 0; commandIndex < args.length; commandIndex++) {
                String arg = args[commandIndex];
                if ("-u".equals(arg)) {
                    pathToUserFile = args[commandIndex + 1];
                    userFileCommandFound = true;
                }

                if ("-m".equals(arg)) {
                    pathToMessageFile = args[commandIndex + 1];
                    messageFileCommandFound = true;
                }
            }

            if  (userFileCommandFound&& messageFileCommandFound) {
                Hashtable<String, UserDTO> cachedUsers = (Hashtable<String, UserDTO>) BaseMessenger.INSTANCE.getCachedUsers();
                FileParser.INSTANCE.readUsersAndMessages(cachedUsers, pathToUserFile, pathToMessageFile);
                BaseMessenger.INSTANCE.printCache();

            }else {
                System.out.println("The command should me of the for : -u C:/path_to_user_file -m C:/path_to_message_file\n"+
                "the command is malformed, either the -u or -m is missing ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
