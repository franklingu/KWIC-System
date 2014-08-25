package CS3213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter movie titles (terminate input by entering 0) ");

        List<String> inputs = new ArrayList<String>();
        String userInput = sc.nextLine();
        while (!userInput.equals("0")) {
            userInput = sc.nextLine();
            inputs.add(userInput);
        }

        System.out.println("Enter words to ignore (terminate input by entering 0) ");
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while(!inputWordToIgnore.equals("0")){
            wordsToIgnore.addWordToIgnore(inputWordToIgnore);
            inputWordToIgnore = sc.nextLine();
        }

        Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }

        String[] result = alphabetizer.getSortedLines();
        for (int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }

        System.exit(0);
    }
}
