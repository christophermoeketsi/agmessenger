/**
 * Created by chris on 2016/03/02.
 */
public class LineValidator {

    public static LineValidator INSTANCE = getINSTANCE();

    public LineValidator() {
    }

    private static LineValidator getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new LineValidator();
        return INSTANCE;
    }

    public  static boolean  isValidUserLine(String line, int currentLineNumber) throws LineFormatException {
        return (hasFollows(line, currentLineNumber) && (hasValidNameAndFollower(line, currentLineNumber)));
    }

    private static boolean hasFollows(String line, int currentLineNumber) throws LineFormatException {
        try {
            String[] lineArray = line.trim().split("follows");
            if (lineArray.length != 2 || line.trim().indexOf("follows") == -1)
                throw new LineFormatException("There was an error reading line " +
                        line + ": Line number " + currentLineNumber +
                        "Lines should be of the form Ward follows Alan. The line does not contain follows"
                );
        } catch (Exception e) {
            if (e instanceof LineFormatException)
                throw (LineFormatException) e;
            throw new RuntimeException(e);
        }
        return true;
    }

    private static boolean hasValidNameAndFollower(String line, int currentLineNumber) throws LineFormatException {
        try {
            String[] lineArray = line.trim().split("follows");
            String followName = lineArray[0].trim();
            String[] userNames = lineArray[1].trim().split(",");
            if (followName.trim().length() == 0) {
                throw new LineFormatException("There was an error reading line " +
                        line + ": Line number " + currentLineNumber +
                        "Lines should be of the form Ward follows Alan. The is an empty username"
                );
            }
            if (followName.contains(",")) {
                throw new LineFormatException("There was an error reading line " +
                        line + ": Line number " + currentLineNumber +
                        "Lines should be of the form Ward follows Alan. The follower name contains a a comma."
                );
            }

            for (String user : userNames) {
                if (user.trim().length() == 0) {
                    throw new LineFormatException("There was an error reading line " +
                            line + ": Line number " + currentLineNumber +
                            "Lines should be of the form Ward follows Alan. The is an empty username"
                    );
                }
            }
        } catch (Exception e) {
            if (e instanceof LineFormatException)
                throw (LineFormatException) e;
            throw new RuntimeException(e);
        }
        return true;
    }
}
