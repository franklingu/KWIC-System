package test;

import org.junit.Test;

import static org.junit.Assert.*;

import CS3213.CircularShift;

import java.util.HashSet;

public class CircularShiftTest {

    @Test
    public void testGetCircularShifts() throws Exception {
        CircularShift circularShit = new CircularShift("test this circular shift");
        String[] shifts = circularShit.getCircularShifts();
        HashSet<String> setOfShits = new HashSet<String>();
        for (String str : shifts) {
            setOfShits.add(str);
        }
        assertTrue(setOfShits.size() == 4);
        assertTrue(setOfShits.contains("Test This Circular Shift"));
        assertTrue(setOfShits.contains("This Circular Shift Test"));
        assertTrue(setOfShits.contains("Circular Shift Test This"));
        assertTrue(setOfShits.contains("Shift Test This Circular"));
    }
}