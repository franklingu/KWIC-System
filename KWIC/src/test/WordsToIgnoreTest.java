package test;

import CS3213.WordsToIgnore;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordsToIgnoreTest {

    @Test
    public void testIsWordIgnored() throws Exception {
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();

        assertFalse(wordsToIgnore.isWordIgnored("the"));

        wordsToIgnore.addWordToIgnore("the");
        wordsToIgnore.addWordToIgnore("of");
        wordsToIgnore.addWordToIgnore("");
        assertTrue(wordsToIgnore.isWordIgnored("the"));
        assertTrue(wordsToIgnore.isWordIgnored("of"));
        assertTrue(wordsToIgnore.isWordIgnored(""));
        assertFalse(wordsToIgnore.isWordIgnored("after"));
        assertFalse(wordsToIgnore.isWordIgnored("before"));

        wordsToIgnore.addWordToIgnore("of"); // add duplicated word
        wordsToIgnore.addWordToIgnore("after");
        wordsToIgnore.removeWordToIgnore("the");
        wordsToIgnore.removeWordToIgnore("");
        assertFalse(wordsToIgnore.isWordIgnored("the"));
        assertTrue(wordsToIgnore.isWordIgnored("of"));
        assertFalse(wordsToIgnore.isWordIgnored(""));
        assertTrue(wordsToIgnore.isWordIgnored("after"));
        assertFalse(wordsToIgnore.isWordIgnored("before"));
    }
}