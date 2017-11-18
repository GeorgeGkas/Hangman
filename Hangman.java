import java.util.Arrays;
import java.util.Scanner;

/**
 * The Hangman class contains the implementation of the hangman game.
 *
 * @author <a href="mailto:georgegkas@gmail.com">George Gkasdrogkas</a>
 * @version 1.0.0
 * @since 2017-10-17
 */
public class Hangman {
  private final Scanner input;
  private final Lexicon wordlist;
  private String word; // the word to guess
  private char[] currentFound; // the found letters so far
  private final int maxGuesses;
  private int guessesLeft;
  private char guess; // the current input guess
  private int lettersToFind;

  public Hangman() {
    this.wordlist = new Lexicon();
    this.maxGuesses = 8;
    this.input = new Scanner(System.in);
  }

  /**
   * Read user input.
   */
  private char getGuess() {
    System.out.println("You have " + this.guessesLeft + " guesses left.");
    System.out.print("Your guess: ");
    char choice = input.next().charAt(0);
    
    /**
     * Accept only letters as input from user.
     */
    while (!this.isLetter(choice)) {
      System.out.println("Invalid input! Use only letters a-Z.");
      System.out.print("Your guess: ");
      choice = input.next().charAt(0);
    }

    return (char) (choice & 0x5f); // to uppercase
  }

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean correctGuess() {
    return this.word.indexOf(this.guess) > -1;
  }

  /**
   * Search through word and update currentFound char array in parallel.
   */
  private void updateFoundLetters() {
    for (int index = this.word.indexOf(this.guess); index >= 0; index = this.word.indexOf(this.guess, index + 1)) {
      /**
       * Update currentFound only if user has not already provide the same input.
       */
      if (this.currentFound[index] == '-') {
        this.currentFound[index] = this.guess;
        --this.lettersToFind;
      } else {
        System.out.println("You already guessed " + this.guess);
        break;
      }
    }
  }

  private void printFoundLetters() {
    System.out.print("The random word is now: ");
    System.out.println(this.currentFound);
  }

  public void reset() {
    this.word = wordlist.getWord();
    this.guessesLeft = this.maxGuesses;
    this.currentFound = new char[word.length()];
    this.lettersToFind = this.word.length();
    Arrays.fill(this.currentFound, '-');
  }

  public void start() {
    do {
      this.printFoundLetters();
      this.guess = this.getGuess();
      if (this.correctGuess()) {
        System.out.println("The guess is CORRECT!");

        this.updateFoundLetters();
      } else {
        System.out.println("There are no " + this.guess + "'s in the word.");
        --this.guessesLeft;
      }
    } while(this.guessesLeft > 0 && this.lettersToFind != 0);

    if (this.lettersToFind == 0) {
      System.out.println("Congratulations! You guessed the word: " + this.word);
    } else {
      System.out.println("Hanged! The word was: " + this.word);
    }
  }
}
