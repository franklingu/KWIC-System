package CS3213;

import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InputParser movieTitles = new InputParser();

        System.out.println("Enter movie titles (terminate input by entering 0) ");

        String userInput = sc.nextLine();
        while(!userInput.equals("0")){
            movieTitles.addTitle(userInput);
            userInput = sc.nextLine();
        }


        System.out.println("Enter words to ignore (terminate input by entering 0) ");
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while(!inputWordToIgnore.equals("0")){
            wordsToIgnore.addWordToIgnore(inputWordToIgnore);
            inputWordToIgnore = sc.nextLine();
        }

        CircularShift[] shifters = new CircularShift[movieTitles.getNumberOfTitles()];
        Alphabetizer alphabetizer = new Alphabetizer();
        for(int i=0; i<shifters.length;i++){
            shifters[i] = new CircularShift(movieTitles.getTitleAtIndex(i));
            alphabetizer.addLines(shifters[i].getCircularShifts());
        }

        String[] result = alphabetizer.getSortedLines();
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
        System.exit(0);
    }
}
