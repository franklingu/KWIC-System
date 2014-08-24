package test;

import CS3213.InputParser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Sudarsan on 8/24/2014.
 */
public class InputParserTest {

    @Test
    public void testAddTitle() throws Exception{
        InputParser parser = new InputParser();
        String[] movies = {"Iron MAn", "man Of Steel", "the fast AnD furiOUS"};
        for(int i=0;i<movies.length;i++){
            parser.addTitle(movies[i]);
        }
        String[] output = parser.getAllTitles();
        assertTrue(output.length == 3);
        assertEquals("iron man", output[0]);
        assertEquals("man of steel", output[1]);
        assertEquals("the fast and furious", output[2]);
    }
}
