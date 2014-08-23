package CS3213;

/**
 * Created by junchao on 8/23/2014.
 */
public class CircularShift {
    public static String DELIMETER = " ";
    private String _line;

    public CircularShift(String line) {
        this._line = line;
    }

    public String[] getCircularShifts() {
        String[] words = this._line.split(DELIMETER);
        String[] shifts = new String[words.length];
        shifts[0] = this._line;

        for (int i=1;i<words.length;i++) {
            shifts[i] = this.getShiftedLine(i, words);
        }

        return shifts;
    }

    private String getShiftedLine(int index, String[] words) {
        StringBuilder builder = new StringBuilder();
        for (int i=index;i<words.length;i++) {
            builder.append(words[i]);
            builder.append(DELIMETER);
        }
        for (int i=0;i<index;i++) {
            builder.append(words[i]);
            builder.append(DELIMETER);
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}
