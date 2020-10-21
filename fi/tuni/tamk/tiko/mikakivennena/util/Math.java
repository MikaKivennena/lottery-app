package fi.tuni.tamk.tiko.mikakivennena.util ;

/**
* The class Math contains methods that can be used in various ways.
*
* @author Mika Kivennenä
*/
public class Math {
    /**
    *getRandom int determines and int between given min and max values
    *
    *This method takes in two integers, min and max from user.
    *It calculates a random value between the two integers.
    *
    *@param min Minimum value in range that the number is generated in.
    *@param max Maximum value in range that the number is generated in.
    *@return returns the random number that this method generates
    */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}