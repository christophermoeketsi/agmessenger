/**
 * Created by chris on 2016/03/04.
 */
public class MessageLineException extends Exception {

    public MessageLineException(String message) {
        super(message);
    }

    public MessageLineException(Throwable cause) {
        super(cause);
    }

    public MessageLineException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageLineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
