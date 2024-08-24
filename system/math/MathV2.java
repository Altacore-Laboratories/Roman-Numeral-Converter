package system.math;
import java.util.*;

/**
 * This class is used as the central place to where the more complex mathematical aspects of this project is computed.
 *
 * @author Shadow Kitty
 * @see RomanNumerals
 */
public final class MathV2 {
  /**
   * Makes this class uninstantiable.
   */
  private MathV2() {
  }

  /**
   * Rounds the provided value to the nearest factor.
   *
   * @param value  The value to round.
   * @param factor The factor used for rounding.
   * @return A value rounded to the nearest factor.
   */
  public static double round(double value, double factor) {
    return Math.round(value / factor) * factor;
  }

  /**
   * Breaks a number into its components. <blockquote>Example: 1253 = [1000, 200, 50, 3]</blockquote>
   * @return An array of integers where the provided number was split.
   */
  public static int[] breakInteger(int num){
    //Create important variables.
    boolean isNegative = num < 0;
    String strNum = String.valueOf(num);
    LinkedList<Integer> componentArray = new LinkedList<>();

    //Splits the number into its components.
    for(int i = 0; i < strNum.length(); i++){
      int endAmt = strNum.length() - (i + 1);
      String component = String.valueOf(strNum.charAt(i));
      if(!component.equals("0")) componentArray.add(Integer.parseInt((isNegative ? "-" : "") + component + ((endAmt > 0) ? "0".repeat(endAmt) : "")));
    }

    //Convert the Component Array into an array of integers of type 'int'.
    int[] output = new int[componentArray.size()];
    for(int i = 0; i < output.length; i++){
      output[i] = componentArray.get(i);
    }

    //Returns the new array of split components.
    return output;
  }
}
