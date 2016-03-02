/**
 * Created by chris on 2016/03/02.
 */
public class MessengerException extends Exception {
    private String message;
    public MessengerException() {
    }

    public MessengerException(String message) {
        super(message);
    }

    public MessengerException(Throwable cause) {
        super(cause);
    }

    public MessengerException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessengerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
