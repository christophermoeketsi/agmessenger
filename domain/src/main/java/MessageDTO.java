/**
 * Created by chris on 2016/03/02.
 */
public class MessageDTO {

    private String userName;
    private String message;

    public MessageDTO(String userName,String message) {
        this.message = message;
        this.userName  = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
