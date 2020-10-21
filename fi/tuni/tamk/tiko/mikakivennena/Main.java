package fi.tuni.tamk.tiko.mikakivennena;

import fi.tuni.tamk.tiko.mikakivennena.util.Math;
import fi.tuni.tamk.tiko.mikakivennena.util.Arrays;
import fi.tuni.tamk.tiko.mikakivennena.util.MyConsole;

/**
* Lottery app where you give numbers and see how long it takes to get the jackpot
*
* This app takes in your lottery numbers and cycles them week to week until you hit the jackpot.
* This is the main class but there are few additional classes that are Math, Arrays and MyConsole.
* There's documentation on each class and the methods they hold in.
*
*@author  Mika Kivennenä
*/
public class Main {
    static int min = 1;
    static int max = 20;
    static int lottoNumberAmount = 7;
    static String errorMessageNonNumeric = "Please give an actual number";
    static String errorMessageNonMinAndMax = "Please give a unique number between " + min + " and "+ max;
    static int[] lottoNumbers = new int[lottoNumberAmount];
    static int[] numbersArray = new int[max];
    static int[] userNumbers = new int[lottoNumberAmount];
    static int[][] bestOf = {{0,0,0,0,0},{0,0,0,0,0}};
    static int weeks = 0;
    static int years = 0;
/**
* Main method off the app that takes in your lotto numbers and checks how long it would take for you to hit the jackpot. 
*
* This main method contains the basic core for the app with some methods used in this class and several methods from other custom classes.
* You can give the numbers while running the app or you can give them one by one during the app
*
*@param args User can give their numbers when starting the app
* @author Mika Kivennenä
*/
    public static void main(String [] args) {
        // if user gave enough arguments, create user numbers array from them
        // else ask the numbers one by one
        if(args.length == lottoNumberAmount) {
            userNumbers = Arrays.toIntArray(args);
        } else {
            askNumbers(userNumbers);
        }
        
        createArrayOfNumbers(numbersArray);
        
        int howManyCorrect = 0;
        int correctIndex = 0;
        int yearIndex = 0;
        boolean stopLottery = false;
        boolean underLifeTime = false;

        while(!stopLottery) {
            while(!underLifeTime) {
                calculateLotto(lottoNumbers);
                howManyCorrect = Arrays.containsSameValues(userNumbers, lottoNumbers);
                calculateYears();
                System.out.println("You got " + howManyCorrect + " correct! This was week: " + weeks + " of year: " + years);
                
                if(howManyCorrect > bestOf[0][0]) {
                    bestOf[0][0] = howManyCorrect;
                    bestOf[1][0] = years;
                    
                }
                
                if(howManyCorrect == lottoNumberAmount) {
                    if(years > 100) {
                        System.out.println("\nYou won the lottery but it took you more than a lifetime");
                        resetLottery();
                    } else {
                        System.out.println("\nCongratulations! You won lottery in a lifetime!");
                        underLifeTime = true;
                        stopLottery = true;
                    }
                }
                Arrays.sort2DArray(bestOf);
            }
        }
        endGame();
    }

    // Creates an array of numbers. Size is determined under Main class with max integer
    private static int[] createArrayOfNumbers(int[] numbersArray) {
        int tempInt = 1;
        for(int i=0; i<max; i++) {
            numbersArray[i] = tempInt;
            tempInt++;
        }
        return numbersArray;
    }
    // Creates an array of randomized lottery numbers and returns it
    private static int[] calculateLotto(int[] returnArray) {
        int[] tempArray = new int[numbersArray.length];
        for(int i=0; i<tempArray.length; i++) {
            tempArray[i] = numbersArray[i];
        }

        for(int i=0; i<returnArray.length; i++) {
            int tempInt = Math.getRandom(min,tempArray.length-1);
            returnArray[i] = tempArray[tempInt];
            tempArray = Arrays.removeIndex(tempArray, tempInt);
        }
        return returnArray;
    }

    // This uses MyConsole class to ask user for lottery numbers and returns an array of them
    private static int[] askNumbers(int[] lottoArray) {
        for(int i=0; i<lottoArray.length; i++) {
            System.out.println("Give a number between " + min + "-" +max);
            lottoArray[i] = MyConsole.readInt(min,max,errorMessageNonNumeric,errorMessageNonMinAndMax);
        }
        return lottoArray;
    }

    private static void print2DArray(int[][] arrayToPrint) {
        for(int i=0; i<5; i++) {
            System.out.println("You got " + arrayToPrint[0][i] + " and it took " + arrayToPrint[1][i] + " years.");
        }
    }

    // Adds weeks until week 52 is reached. Then adds one to years and restarts weeks counter.
    private static void calculateYears() {
        weeks++;
        if(weeks >= 52) {
            years++;
            weeks = 0;
        }
    }

    // Prints all the available info if the user wants it.
    private static void printInfo() {
        String[] userString = Arrays.prefixNumbers(userNumbers, "0");
        String[] lottoString = Arrays.prefixNumbers(lottoNumbers, "0");
        
        System.out.print("Your numbers were: ");
        for(int i=0; i<userString.length; i++) {
            System.out.print(userNumbers[i] + " ");
        }

        System.out.print("\nCorrect numbers were: ");
        for(int i=0; i<userString.length; i++) {
            System.out.print(lottoNumbers[i] + " ");
        }
        System.out.println("\nHere are your best results:");
        print2DArray(bestOf);
    }

    // At the end of the game run this
    private static void endGame() {
        boolean endCycle = false;
        String answer = "";
        System.out.println("Would you like to see numbers and your top 5 results? Y/N");
        while(!endCycle) {
            answer = MyConsole.readLine();
            if(answer.equalsIgnoreCase("Y")) {
                printInfo();
                endCycle = true;
            }
            else if(answer.equalsIgnoreCase("N")) {
                System.out.println("Okay then. Congratulations on winning the lottery!");
                endCycle = true;
            }
        }
    }

    private static void resetLottery() {
        for(int i=0; i<bestOf.length; i++) {
            for(int j=0; j<bestOf[i].length; j++) {
                bestOf[i][j] = 0;
            }
        }
        years = 0;
        weeks = 0;
    }
}