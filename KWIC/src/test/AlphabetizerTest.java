package test;

import CS3213.Alphabetizer;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetizerTest {

    @Test
    public void testGetSortedLines() throws Exception {
        Alphabetizer alphabetizer = new Alphabetizer();

        String[] lines = {"test a line", "a simple line", "this is test", "easy task"};
        alphabetizer.addLines(lines);
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 4);
        assertEquals("a simple line", output[0]);
        assertEquals("easy task", output[1]);
        assertEquals("test a line", output[2]);
        assertEquals("this is test", output[3]);
    }
}