package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class is to generate a list of all circular shifts based on the string given.
 */
public class CircularShift {
    public static String DELIMITER = " ";
    private String _line;
    private WordsToIgnore _wordsToIgnore;

    /**
     * input should not be null
     * @param line
     */
    public CircularShift(String line) {
        assert(line != null);
        this._line = line;
        this._wordsToIgnore = WordsToIgnore.getWordsToIgnore();
    }

    public String[] getCircularShifts() {
        String[] words = this._line.split(DELIMITER);
        String[] shifts = new String[words.length];
        shifts[0] = this._line;

        for (int i=1;i<words.length;i++) {
            shifts[i] = this.getShiftedLine(i, words);
        }

        return getShiftsWithoutIgnoredWordLeading(shifts);
    }

    private String getShiftedLine(int index, String[] words) {
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

    private String[] getShiftsWithoutIgnoredWordLeading(String[] shifts) {
        List<String> shiftList = new ArrayList<String>(Arrays.asList(shifts));

        Iterator<String> iter = shiftList.iterator();
        while (iter.hasNext()) {
            if (isShiftStartingWithIgnoredWord(iter.next())) {
                iter.remove();
            }
        }

        return shiftList.toArray(new String[shiftList.size()]);
    }

    private boolean isShiftStartingWithIgnoredWord(String line) {
        return this._wordsToIgnore.isWordIgnored(line.split(DELIMITER)[0]);
    }
}
