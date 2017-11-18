import java.util.Random;

/**
 * The Lexicon class is used to manage a pre-defined set of words.
 *
 * @author <a href="mailto:georgegkas@gmail.com">George Gkasdrogkas</a>
 * @version 1.0.0
 * @since 2017-10-17
 */
public class Lexicon {
  /**
   * Represents a wordlist.
   */
  private final String[] words = {
    "PASSWORD",
    "WITCHER",
    "MAN",
    "WOMAN",
    "DOG",
    "CAT",
    "BANK",
    "FAMILY",
    "SCORPION",
    "NOTHING",
    "MIDNIGHT",
    "CHICKEN",
    "GINGER",
    "BANANA",
    "APPLE",
    "PRINCE",
    "CHEESE",
    "ISLAND",
    "RAINBOW",
    "SYSTEM"
  };

  public Lexicon() {
    // empty
  }

  /**
   * This method is used to return a random element from <i>words</i> array.
   *
   * @return A different array element from <i>words</i> array. 
   */
  public String getWord() {
    /**
     * We use <i>System.currentTimeMillis()</i> as seed value to guarantee the
     * return of different element in each call.
     */
    return this.words[(new Random(System.currentTimeMillis())).nextInt(words.length)];
  }
}
