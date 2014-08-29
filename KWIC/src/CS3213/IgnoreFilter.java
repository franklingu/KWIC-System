package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by junchao on 8/29/2014.
 */
public class IgnoreFilter {
    private static WordsToIgnore _wordsToIgnore = WordsToIgnore.getWordsToIgnore();
    public static final String DELIMITER = " ";

    public static String ignoreFilter(String input) {
        String separator = System.lineSeparator();
        String[] lines = input.split(separator);
        List<String > lineList = new ArrayList<String>();
        for (String str : lines) {
            String transformed = transformLine(str);
            if (transformed != null) {
                lineList.add(transformed);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : lineList) {
            builder.append(str).append(separator);
        }

        return builder.toString();
    }

    private static String transformLine(String line) {
        String[] words = line.split(DELIMITER);
        if (words.length == 0 || _wordsToIgnore.isWordIgnored(words[0])) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        for (String str : words) {
            if (!str.isEmpty() && !_wordsToIgnore.isWordIgnored(str)) {
                builder.append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).append(DELIMITER);
            } else if (!str.isEmpty() && _wordsToIgnore.isWordIgnored(str)) {
                builder.append(str).append(DELIMITER);
            }
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        return builder.toString();
    }
}
