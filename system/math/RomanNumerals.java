package system.math;

import java.util.*;
import java.util.stream.*;

/**
 * A complex class for converting roman numerals to integers & vice versa.
 *
 * @author Shadow Kitty
 * @version 1.0
 * @see MathV2
 */
public final class RomanNumerals {
  //The table used for conversion
  public static final Table<String, Integer>[] CONVERSION_TABLE = new Table[]{
          new Table<>("I", 1),
          new Table<>("V", 5),
          new Table<>("X", 10),
          new Table<>("L", 50),
          new Table<>("C", 100),
          new Table<>("D", 500),
          new Table<>("M", 1000)
  };

  //Static Fields
  private static final int maxPermissible = 3;
  private static final int maxThreshold = CONVERSION_TABLE[CONVERSION_TABLE.length - 1].value * maxPermissible;

  /**
   * Makes this class uninstantiable.
   */
  private RomanNumerals() {
  }

  /**
   * Enumerates the number into a table of roman numerals.
   *
   * @param num The number to enumerate.
   * @return The enumerated number array.
   */
  public static Table<String, Integer>[] enumerateNumber(int num) {
    Table<String, Integer>[] enumeration = Table.defaultArray(CONVERSION_TABLE);

    //First, we use moduli to convert the number into a base format
    for (int i = enumeration.length - 1; i >= 0; i--) {
      Table<String, Integer> table = enumeration[i];
      Table<String, Integer> convTable = CONVERSION_TABLE[i];
      int times = (int) Math.floor(num / convTable.value);
      table.value = times;

      //Sets future tables where neccessary
      if (i < enumeration.length - 1 && times > maxPermissible) {
        Table<String, Integer> futureTable = enumeration[i + 1];
        int overflow = (int) Math.floor(table.value / maxPermissible);
        table.value = table.value % maxPermissible;
        futureTable.value = futureTable.value + overflow;
      }
      num %= convTable.value;
    }

    //Finally, we make sure all values are cast accordingly
    for (int i = 0; i < enumeration.length; i++) {
      Table<String, Integer> table = enumeration[i];
      Table<String, Integer> convTable = CONVERSION_TABLE[i];
      if (i < enumeration.length - 1) {
        Table<String, Integer> futureTable = enumeration[i + 1];
        Table<String, Integer> futureConvTable = CONVERSION_TABLE[i + 1];
        int times = (int) Math.floor((table.value * convTable.value) / futureConvTable.value);
        if (times == 0) continue;
        table.value = 0;
        futureTable.value = futureTable.value + times;
      }
    }
    return enumeration;
  }

  /**
   * @param num The number to convert to roman numerals.
   * @return A representation of the provided number in roman numerals.
   */
  public static String toRoman(int num) {
    if (num < 1) throw new ConversionError("Negative numbers cannot be converted to roman numerals.");
    if (num > maxThreshold) throw new ConversionError("Numbers higher than " + maxThreshold + " are not supported yet.");
    String output = "";
    int[] splitNum = MathV2.breakInteger(num);

    //Build enumeration representations of the number.
    for(int component : splitNum){
      Table<String, Integer>[] enumerated = enumerateNumber(component);
      String rep = Arrays.stream(enumerated).map(element -> element.key.repeat(element.value)).collect(Collectors.joining());
      String reverseRep = "";
      for(int i = rep.length() - 1; i >= 0; i--) reverseRep += rep.charAt(i);
      if(component >= toNumber(reverseRep)) output += reverseRep;
      else output += rep;
    }
    return output;
  }

  /**
   * Converts roman numerals to an integer representation.
   *
   * @param romanNumerals A string that contains valid roman numeral characters.
   * @return An integer whose value is that of the provided roman numeral argument.
   */
  public static int toNumber(String romanNumerals) {
    romanNumerals = romanNumerals.trim();
    if (romanNumerals.isEmpty()) throw new ConversionError("The provided numeral string is empty.");
    //Create some variables for calculation.
    int output = 0;
    LinkedHashMap<String, Integer> convMap = Table.createHashMap(CONVERSION_TABLE);

    //Iterate over the numeral array.
    for (int i = 0; i < romanNumerals.length(); i++) {
      String numeral = String.valueOf(romanNumerals.charAt(i)).toUpperCase();
      int numeralValue = convMap.getOrDefault(numeral, -1);
      if (numeralValue == -1)
        throw new ConversionError(String.format("The character \"%s\" isn't recognized as any known roman numeral.", numeral));

      //Calculate the value of numerals.
      if (i < romanNumerals.length() - 1) {
        String futureNumeral = String.valueOf(romanNumerals.charAt(i + 1)).toUpperCase();
        int futureNumeralValue = convMap.getOrDefault(futureNumeral, -1);
        if (futureNumeralValue == -1)
          throw new ConversionError(String.format("The character \"%c\" isn't recognized as any known roman numeral.", romanNumerals.charAt(i)));
        if (numeralValue < futureNumeralValue) output -= numeralValue;
        else output += numeralValue;
      } else output += numeralValue;
    }
    return output;
  }
}
