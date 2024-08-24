package system.math;

/**
 * An exception class used during a failed conversion attempt.
 *
 * @author Shadow Kitty
 * @apiNote This custom exception is thrown when the <code>RomanNumerals</code> class can't convert the provided input.
 */
public class ConversionError extends RuntimeException {
  public ConversionError(String issue) {
    super(issue);
  }
}
