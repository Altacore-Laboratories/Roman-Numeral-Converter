package system.main;

import system.math.*;

/**
 * The main class for running the program. This class is used to test stuff related to the project.
 * This class is optional, and can be deleted from the project without any harm.
 *
 * @author Shadow Kitty
 * @version 1.0
 */

public final class Main {
  /**
   * The method used to run the entire program
   *
   * @param args System Provided Arguments.
   */
  public static void main(String[] args) {
    //Convert an integer to roman numerals.
    System.out.println(RomanNumerals.toRoman(4)); //Output: IV

    //Convert roman numerals to an integer.
    System.out.println(RomanNumerals.toNumber("IV")); //Output: 4
  }
}
