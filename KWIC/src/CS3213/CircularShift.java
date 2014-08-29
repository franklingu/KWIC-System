package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class is to generate a list of all circular shifts based on the string given.
 */
public class CircularShift {
    public static final String DELIMITER = " ";

    public static String circularShift(String input) {
        String separator = System.lineSeparator();
        String[] lines = input.split(separator);
        List<String > lineList = new ArrayList<String>();
        for (String str : lines) {
            lineList.addAll(new ArrayList<String>(Arrays.asList(getCircularShifts(str))));
        }
        StringBuilder builder = new StringBuilder();
        for (String str : lineList) {
            builder.append(str).append(separator);
        }

        return builder.toString();
    }

    private static String[] getCircularShifts(String line) {
        String[] words = line.split(DELIMITER);
        String[] shifts = new String[words.length];
        shifts[0] = line;

        for (int i=1;i<words.length;i++) {
            shifts[i] = getShiftedLine(i, words);
        }

        return shifts;
    }

    private static String getShiftedLine(int index, String[] words) {
        StringBuilder builder = new StringBuilder();

        for (int i=index;i<words.length;i++) {
            builder.append(words[i]);
            builder.append(DELIMITER);
        }
        for (int i=0;i<index;i++) {
            builder.append(words[i]);
            builder.append(DELIMITER);
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
