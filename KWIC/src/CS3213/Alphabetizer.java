package CS3213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by junchao on 8/23/2014.
 */
public class Alphabetizer {
    private List<String> _lines;

    public Alphabetizer() {
        this._lines = new ArrayList<String>();
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
}
