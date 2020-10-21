package fi.tuni.tamk.tiko.mikakivennena.util;

import java.io.Console; 
/**
* Class that contains console methods that can be used to ask input from user
*
*@author Mika Kivennenä
 */
public class MyConsole {
    static Console c = System.console();
    /**
    * readInt method takes several arguments and returns user input
    *
    * Asks user input until the user gives valid input.
    * If the user gives invalid input, return error messages depending on input
    *
    *@param min Minimum value user is allowed to give
    *@param max Maximum value user is allowed to give
    *@param errorMessageNonMinAndMax is what the errors text returned if the number is out of range
    *@param errorMessageNonNumeric is the text variable that determines non-number error message
    *@return Returns an error message if the user input is not a number or is out of range
    *@author Mika Kivennenä
    */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        int input = 0;
        boolean correctInput = false;
        while(!correctInput) { 
            try {
                input = Integer.parseInt(c.readLine());
                if(input >= min && input <= max) {
                    correctInput = true;
                } else {
                    System.out.println(errorMessageNonMinAndMax);
                }
            } catch(NumberFormatException e) {
            System.out.println(errorMessageNonNumeric);
            }
        }
        return input;
    }
    /**
    *This method reads user input.
    *
    *@return Returns the string that user types in
    */
    public static String readLine() {
        String answer = c.readLine();
        return answer;
    }
       
}