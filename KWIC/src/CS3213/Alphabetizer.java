package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by junchao on 8/23/2014.
 */
public class Alphabetizer {

    public static String alphabetize(String input) {
        String separator = System.lineSeparator();
        String[] lines = input.split(separator);
        List<String > lineList = new ArrayList<String>(Arrays.asList(lines));
        Collections.sort(lineList);
        StringBuilder builder = new StringBuilder();
        for (String str : lineList) {
            builder.append(str).append(separator);
        }

        return builder.toString();
    }
}
