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



}
