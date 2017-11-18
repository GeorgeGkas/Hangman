import java.util.Scanner;

/**
 * The Game class is a general purpose class that works as wrapper to play the game.
 *
 * @author <a href="mailto:georgegkas@gmail.com">George Gkasdrogkas</a>
 * @version 1.0.0
 * @since 2017-10-17
 */
public class Game {
  private static Hangman hangman;

  /**
   * This is the main method of the class. We use it only to initiate class properties.
   * We then make use of loop() method to run the actual program.
   */
  public static void main(String[] args) {
    hangman = new Hangman();
    loop();
  }

  /**
   * This method is used as main program loop.
   */
  private static void loop() {
    while (menuChoice() != 'E') {
      hangman.reset();
      hangman.start();
    }
  }

  /**
   * This method prints a simple menu to the user.
   * @return A char, representing the choice of the user.
   */
  private static char menuChoice() {
    Scanner input = new Scanner(System.in);
    char choice;

    System.out.print("MAIN MENU\n");
    System.out.print("\t - Start a new Game (S)\n");
    System.out.print("\t - Exit (E)\n");
    System.out.print("Please enter your choice: ");

    choice = input.next().charAt(0);
    while (choice != 'E' && choice != 'S') {
      System.out.println("Invalid choice!");
      System.out.print("Please enter your choice: ");
      choice = input.next().charAt(0);
    }

    return choice;
  }
}
