import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by chris on 2016/03/02.
 */
public class ParserTest {

    @Test
    public void testLineParsing (){
        String testString   ="Ward follows John";
        List<UserDTO> userDTOs = FileParser.INSTANCE.parserUserLine(testString,0);
        Assert.assertEquals(2, userDTOs.size());
        UserDTO userDTO  = userDTOs.get(0);
        Assert.assertEquals(new UserDTO("John"), userDTO);
        Assert.assertEquals(true, userDTO.getFollowers().contains(new UserDTO("Ward")));
    }

    @Test
    public void testMulitipleLineParsing (){
        String testString   ="Ward follows Martin, Alan";
        List <UserDTO> userDTOs= FileParser.INSTANCE.parserUserLine(testString, 0);
        Assert.assertEquals(3, userDTOs.size());
    }


    @Test
    public void testRepeatingName (){
        String testString   ="Ward follows Martin, Alan, Martin";
        List <UserDTO> userDTOs= FileParser.INSTANCE.parserUserLine(testString,0);
        Assert.assertEquals(3, userDTOs.size());
    }


    @Test
    public void testReadFile () {
        List <UserDTO> userDTOs= FileParser.INSTANCE.readUsersFromFile("/home/chris/workspace/git/agmessenger/fileparserutils/src/test/test_files/followersTestFile");
        Assert.assertEquals(3, userDTOs.size());
    }


}
