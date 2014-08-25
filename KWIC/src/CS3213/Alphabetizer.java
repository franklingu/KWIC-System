package CS3213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by junchao on 8/23/2014.
 */
public class Alphabetizer {
    private List<String> _lines;
    private static Alphabetizer _instance;

    private Alphabetizer() {
        this._lines = new ArrayList<String>();
    }

    public static Alphabetizer getAlphabetizer() {
        if (_instance == null) {
            _instance = new Alphabetizer();
        }

        return _instance;
    }

    public void addLines(String[] lines) {
        for (String str : lines) {
            this._lines.add(str);
        }
    }

    public String[] getSortedLines() {
        Collections.sort(this._lines);
        return this._lines.toArray(new String[this._lines.size()]);
    }

    public void clearContent() {
        this._lines.clear();
    }
}
