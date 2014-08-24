package CS3213;

import java.util.HashSet;

/**
 * Created by junchao on 8/23/2014.
 */
public class WordsToIgnore {
    private HashSet<String> _wordsToIgnore;
    private static WordsToIgnore _instatnce;
    private WordsToIgnore() {
        this._wordsToIgnore = new HashSet<String>();
    }

    public static WordsToIgnore getWordsToIgnore() {
        if (_instatnce == null) {
            _instatnce = new WordsToIgnore();
        }

        return _instatnce;
    }

    public void addWordToIgnore(String word) {
        assert(word != null);
        this._wordsToIgnore.add(word);
    }

    public void removeWordToIgnore(String word) {
        assert(word != null);
        this._wordsToIgnore.remove(word);
    }

    public boolean isWordIgnored(String word) {
        assert(word != null);
        return this._wordsToIgnore.contains(word);
    }
}
