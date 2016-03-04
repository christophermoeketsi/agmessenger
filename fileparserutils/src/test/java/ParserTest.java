import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by chris on 2016/03/02.
 */
public class ParserTest {


    //These tests test the passing of the user file
    //==================================This is where they start=============================================
    @Test
    public void testLineParsing() {
        String testString = "Ward follows John";
        List<UserDTO> userDTOs = FileParser.INSTANCE.parserUserLine(testString, 0);
        Assert.assertEquals(2, userDTOs.size());
        UserDTO userDTO = userDTOs.get(0);
        Assert.assertEquals(new UserDTO("John"), userDTO);
        Assert.assertEquals(true, userDTO.getFollowers().contains(new UserDTO("Ward")));
    }

    @Test
    public void testMulitipleLineParsing() {
        String testString = "Ward follows Martin, Alan";
        List<UserDTO> userDTOs = FileParser.INSTANCE.parserUserLine(testString, 0);
        Assert.assertEquals(3, userDTOs.size());
    }


    @Test
    public void testRepeatingName() {
        String testString = "Ward follows Martin, Alan, Martin";
        List<UserDTO> userDTOs = FileParser.INSTANCE.parserUserLine(testString, 0);
        Assert.assertEquals(3, userDTOs.size());
    }


    @Test
    public void testReadFile() {
        List<UserDTO> userDTOs = FileParser.INSTANCE.readUsersFromFile("/home/chris/workspace/git/agmessenger/fileparserutils/src/test/test_files/followersTestFile");
        Assert.assertEquals(3, userDTOs.size());
    }

    //==================================This is where they end=============================================

    //These tests test the parsing of the message file
    //==================================This is where they start =============================================
    @Test
    public void testMessageLineParsing() {
        String testString = "Ward > 123";
        MessageDTO messageDTO = FileParser.INSTANCE.parseMessageLine(testString, 0);
        Assert.assertEquals("Ward", messageDTO.getUserName());
        Assert.assertEquals(" 123", messageDTO.getMessage());
    }


    @Test
    public void testMessageLineParsingWithMoreDeliminators() {
        String testString = "Ward >>>>>>>123";
        MessageDTO messageDTO = FileParser.INSTANCE.parseMessageLine(testString, 0);
        Assert.assertEquals("Ward", messageDTO.getUserName());
        Assert.assertEquals(">>>>>>123", messageDTO.getMessage());
    }

    //==================================This is where they start =============================================

}
