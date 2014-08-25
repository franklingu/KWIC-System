package CS3213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 */
public class Main {
    private static final String APPEND_CMD = "append";
    private static final String CLEAR_CMD = "clear";
    private static final String IGNORE_CMD = "ignore";
    private static final String EXIT_CMD = "exit";

    private static List<String> _inputs = new ArrayList<String>();
    private static WordsToIgnore _wordsToIgnore = WordsToIgnore.getWordsToIgnore();
    private static Alphabetizer _alphabetizer = Alphabetizer.getAlphabetizer();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (executeInput(sc.nextLine())) {
            _alphabetizer.clearContent();
            for (String str : _inputs) {
                CircularShift shifter = new CircularShift(str);
                _alphabetizer.addLines(shifter.getCircularShifts());
            }
            String[] result = _alphabetizer.getSortedLines();
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }

        System.exit(0);
    }

    private static boolean executeInput(String input) {
        if (input.startsWith(EXIT_CMD)) {
            return false;
        }
        switch (getCommand(input)) {
            case APPEND_CMD:
                appendTitle(getRemainingPart(input));
                break;
            case IGNORE_CMD:
                addWordsToIgnore(getRemainingPart(input));
                break;
            case CLEAR_CMD:
                clearStorage();
                break;
            default:
                otherCommands();
                break;
        }

        return true;
    }

    private static void otherCommands() {
        System.out.println("Pls input valid command");
    }

    private static String getCommand(String input) {
        String[] splits = input.split(" ");
        if (splits.length == 0) {
            return "";
        }
        return splits[0];
    }

    private static String getRemainingPart(String input) {
        int pos = input.trim().indexOf(" ");
        if (pos == -1) {
            return "";
        }
        return input.substring(pos + 1);
    }

    private static void appendTitle(String title) {
        if (title.isEmpty()) {
            return;
        }
        _inputs.add(title);
    }

    private static void addWordsToIgnore(String line) {
        String[] words = line.split(" ");
        for (String word : words) {
            _wordsToIgnore.addWordToIgnore(word);
        }
    }

    private static void clearStorage() {
        _inputs.clear();
    }
}
