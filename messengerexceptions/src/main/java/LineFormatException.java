/**
 * Created by chris on 2016/03/02.
 */
public class LineFormatException extends MessengerException {
    public LineFormatException() {
    }

    public LineFormatException(String message) {
        super(message);
    }

    public LineFormatException(Throwable cause) {
        super(cause);
    }

    public LineFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public LineFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
