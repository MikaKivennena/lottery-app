package fi.tuni.tamk.tiko.mikakivennena.util;
/**
* Array class contains different array methods
*
* These methos can be used in various ways in different proejcts
*
*@author Mika Kivennenä
*/
public class Arrays {
/**
* toIntArray method takes in String array and returns an int array.
*
* @param array is the String array converted into an int array
* @return Returns the converted String array as an int array
* @author Mika Kivennenä
*/
    public static int [] toIntArray(String [] array) {
        int[] tempArray = new int[array.length];
        for(int i=0; i<tempArray.length; i++) {
            tempArray[i] = Integer.parseInt(array[i]);
        }
        return tempArray;
    }
/**
* contains method checks if a number is found in array
*
*@param value is the the value that is looked in the given array
*@param array contains the numbers that value is being compared to.
*@return Returns true or false depending on if the given number is found in the array
*@author Mika Kivennenä
*/
    public static boolean contains(int value, int [] array) {
        for(int i=0; i<array.length; i++) {
            if(value == array[i]) {
                return true;
            }
        }
        return false;
    }

/**
* containsSameValues method checks how many values match each other in two separate arrays
*
*@param array1 is the first given array which values are compared to array2. 
*@param array2 is the second given array that array1 is compared to.
*@return Returns int of amount of values that match each other in the two arrays
*@author Mika Kivennenä
*/
    public static int containsSameValues(int[] array1, int[] array2) { 
        int amountOfSame = 0;
        for(int i=0; i<array1.length; i++) {
            for(int j=0; j<array1.length; j++) {
                if(array1[i] == array2[j]) {
                    amountOfSame++;
                }
            }
        }
        return amountOfSame;
    }
    /**
    * removeIndex removes and index from an array
    *
    * Takes in array and an int then removes the given int index from the array returning a shorter array
    *
    * @param inputArray Take in an array that needs to have index removed
    * @param indexToRemove Determines the index that needs to be removed from inputArray
    * @return Returns and array that is now one shorter missing the removed index
    * @author Mika Kivennenä
     */
    public static int[] removeIndex(int[] inputArray, int indexToRemove) {
        int[] newArray = new int[inputArray.length-1];
        inputArray[indexToRemove] = inputArray[inputArray.length-1];
        for(int i=0; i<newArray.length; i++) {
            newArray[i] = inputArray[i];
        }
        return newArray;
    }
    /**
    * Method to sort array of ints from small to big
    *
    * Uses selection sort algorithm to sort the given array so that the smallest int is first and biggest is last
    *
    * @param array Takes in an array of int to be sorted
    * @return Returns the sorted array
     */
    public static  int[] sort(int[] array) {
        int tempInt;
        for(int i=0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++) {
                if(array[j] < array[i]) {
                tempInt = array[j];
                array[j] = array[i];
                array[i] = tempInt;
                }
            }
        }
        return array;
    }
    /**
    * This method adds prefix in front of numbers in an array
    *
    * This array takes in an array of Integers and a String. It then adds the String prefix in front of each integer in array and returns string array.
    *
    *@param intArray this takes in an array of integers
    *@param prefix This method takes in predetermined prefix that will be added to numbers under 10
    *@return Returns a String array with prefixed numbers
    *@author Mika Kivennenä
     */
    public static String[] prefixNumbers(int[] intArray, String prefix) {
        String[] array = new String[intArray.length];
        for(int i=0; i<intArray.length; i++) {
            if(intArray[i] < 10) {
                array[i] = prefix + Integer.toString(intArray[i]);
            }
        }
        return array;
    }
    /**
    * Created specifically for the lottery app
    *
    * This method takes in a 2D-array and sorts the first array from smallest to lowest.
    * Also sets the the year on the other index to correspond with the correct result
    *
    *@param array This method takes in a 2D array of integers
    *@return Returns the given 2D array with both of the arrays sorted
    *@author Mika Kivennenä
     */
    public static  int[][] sort2DArray(int[][] array) {
        int tempScore;
        int tempYear;
        for(int i=0; i<array[0].length; i++) {
            for(int j=i+1; j<array [0].length; j++) {
                if(array[0][j] < array[0][i]) {
                tempScore = array[0][i];
                array[0][i] = array[0][j];
                array[0][j] = tempScore;
                tempYear = array[1][j];
                array[1][j] = array[1][i];
                array[1][i] = tempYear;
                }
            }
        }
        return array;
    }
}