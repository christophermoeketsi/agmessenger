import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by chris on 2016/03/02.
 */
public class BaseMessenger {
    public static  BaseMessenger INSTANCE  =  getINSTANCE();

    private static BaseMessenger getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE  = new BaseMessenger();
        }
        return  INSTANCE;
    }

    public BaseMessenger() {
    }

    public boolean readUsers(String pathToFile){
        try  {
            File file  = new File(pathToFile);
            if(file.exists()){
                BufferedReader bufferedReader   = new BufferedReader(new FileReader(pathToFile));
                String line   = bufferedReader.readLine();
                while(line != null) {

                }
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return true;
    }


}
