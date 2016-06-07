import java.util.*;

public class RPSgame {

    public static void main(String[] args) {

        // Define Array list for history information
        ArrayList<String> outputHistory = new ArrayList<String>();
        // Initialize loop variable
        int continueGame = 1;

        // To properly loop the main menu, so it continues to display the main menu, until the users types, "quit"
        // to exit the program.
        // Ref.: http://code.runnable.com/VFAkPBqJea5m2s09/rock-paper-scissor-game-for-java
        while (continueGame != 0) {

            // Output the Title and Choices the user can pick from.
            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println();
            System.out.println("MAIN MENU");
            System.out.println("=====");
            System.out.println("1. Type 'play' to play");
            System.out.println("2. Type 'history' to view your game history");
            System.out.println("Type 'quit' to stop playing");

            // Set up to accept user input.
            Scanner userInput = new Scanner(System.in); // Reading from System.in
            String playerInput = userInput.next(); // Store the user entry in a string variable

            // Address user issue if the user entry contains mixed case in their entry.
            // (i.e. plaY, HISTORY, qUIt, etc.)
            // Store the uppercase of user input in new variable because strings in Java are immutable.
            // Ref.: http://stackoverflow.com/questions/8464807/touppercase-in-java-does-not-work
            String uppercaseInput = playerInput.toUpperCase();

            // Test the different choices from the user: play, history, quit.  Also, displays message if invalid
            // and if choice typed in.
            switch (uppercaseInput) {
                case ("PLAY"): {
                    // Call the function, playGame(), to play the game and store history results in an
                    // array list.

                    //***** This code will retain the history of a single session.
                    // outputHistory = playGame();

                    // This will save all the sessions of the game in the history array list.
                    //Ref. http://stackoverflow.com/questions/17809910/best-way-to-transfer-value-from-an-arraylist-to-another
                    outputHistory.addAll(playGame());
                    break;
                }
                case ("HISTORY"): {
                    System.out.println("=== GAME HISTORY ===");

                    //Print list with game history. Print the history without the brackets from the array list.
                    // Ref. http://www.coderanch.com/t/440397/java/java/Removing-brackets-arraylist-printout
                    for (String displayHistory : outputHistory) {
                        System.out.println(displayHistory);
                    }
                    System.out.println();
                    break;
                }
                case ("QUIT"): {
                    // Reset the exit variable to exit the loop and program.
                    continueGame = 0;
                    break;
                }
                default: {
                    // Default error message if invalid choice type in.
                    System.out.println("Invalid Choice.");
                    break;
                }
            }
        }
    }

    // Function plays the game.
    public static ArrayList<String> playGame() {
        // This function plays the rock/paper/scisoors game.  In addition to displaying the results,
        // it stores the results into an array list.  It returns an arraylist back to the main function
        // to be display in the history option.
        // Ref. #1: http://stackoverflow.com/questions/11682212/java-returning-method-which-returns-arraylist
        // Ref. #2: http://stackoverflow.com/questions/19562516/return-an-arraylist-method

//    public static void playGame() {
        // Define Array list for history information
        ArrayList<String> gameHistory = new ArrayList<String>();

        // Initialize loop variable.
        int continueChoice = 1;
        // To properly loop the game, so it continues to display the sub menu, until the users types, "quit"
        // to get to the main menu.
        // Ref.: http://code.runnable.com/VFAkPBqJea5m2s09/rock-paper-scissor-game-for-java
        while (continueChoice != 0) {

            // Output the game choices: rock, paper, scissors or quit (to go back to Main Menu)
            System.out.println("Type in 'rock 'paper' or 'scissor' to play");
            System.out.println("Type 'quit' to go back to the Main Menu");
            System.out.println();

            //Get user choice from the game
            Scanner userInput2 = new Scanner(System.in); // Reading from System.in
            String userGameInput = userInput2.next(); // Store the user choice in a string variable

            // Address user issue if the user entry contains mixed case in their entry.
            // (i.e. plaY, HISTORY, qUIt, etc.)
            String uChoice = userGameInput.toUpperCase();

            // Call function to get computer's random choice.
            String cInput = generateComputerChoice();

            // Compares the string to a particular value
            // Ref. http://www.coderanch.com/t/572326/java/java/Testing-string-scanner-input-statement
            // Clean up the output to display in lowercase.
            // Ref. http://www.tutorialspoint.com/java/java_string_tolowercase.htm
            // Update the array list for history data to be returned to the main function.
            if (uChoice.equals("ROCK")) {
                if (cInput.equals("ROCK")) {
                    System.out.println("Computer picks: " + cInput.toLowerCase());
                    System.out.println("User picks: " + uChoice.toLowerCase());
                    System.out.println("You tied!");
                    gameHistory.add("TIE: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());
                }
                if (cInput.equals("PAPER")) {
                    System.out.println("Computer picks: " + cInput.toLowerCase());
                    System.out.println("User picks: " + uChoice.toLowerCase());
                    System.out.println("You lose!");
                    gameHistory.add("LOSS: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());
                }
                if (cInput.equals("SCISSORS")) {
                    System.out.println("Computer picks: " + cInput.toLowerCase());
                    System.out.println("User picks: " + uChoice.toLowerCase());
                    System.out.println("You win!");
                    gameHistory.add("WIN: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());

                }
            } else if (uChoice.equals("PAPER")) {
                        if (cInput.equals("ROCK")) {
                            System.out.println("Computer picks: " + cInput.toLowerCase());
                            System.out.println("User picks: " + uChoice.toLowerCase());
                            System.out.println("You win!");
                            gameHistory.add("WIN: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());

                        }
                        if (cInput.equals("PAPER")) {
                            System.out.println("Computer picks: " + cInput.toLowerCase());
                            System.out.println("User picks: " + uChoice.toLowerCase());
                            System.out.println("You tied!");
                            gameHistory.add("TIE: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());
                        }
                        if (cInput.equals("SCISSORS")) {
                            System.out.println("Computer picks: " + cInput.toLowerCase());
                            System.out.println("User picks: " + uChoice.toLowerCase());
                            System.out.println("You lose!");
                            gameHistory.add("LOSS: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());

                        }

            } else if (uChoice.equals("SCISSORS")) {
                        if (cInput.equals("ROCK")) {
                            System.out.println("Computer picks: " + cInput.toLowerCase());
                            System.out.println("User picks: " + uChoice.toLowerCase());
                            System.out.println("You lose!");
                            gameHistory.add("LOSS: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());
                        }
                        if (cInput.equals("PAPER")) {
                            System.out.println("Computer picks: " + cInput.toLowerCase());
                            System.out.println("User picks: " + uChoice.toLowerCase());
                            System.out.println("You win!");
                            gameHistory.add("WIN: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());

                        }
                        if (cInput.equals("SCISSORS")) {
                            System.out.println("Computer picks: " + cInput.toLowerCase());
                            System.out.println("User picks: " + uChoice.toLowerCase());
                            System.out.println("You tied!");
                            gameHistory.add("TIE: Player-" + uChoice.toLowerCase() + " computer-" + cInput.toLowerCase());
                        }

            } else if (uChoice.equals("QUIT")) {
                        // Reset loop variable to exit while loop and return to the main menu.
                        continueChoice = 0;
                        break;
            } else {
                    System.out.println("Invalid game choice.");
                    System.out.println("Valid choices are: 'rock', 'paper' 'scissors' or 'quit'");
                    System.out.println();
            }

        }
        // Exit the playGame loop and return the history array list.
        return gameHistory;
    }

    // Function creates computer's choice
    public static String generateComputerChoice() {
        Random randomChoice = new Random();
        // Used the random class to randomly choose values 0-2.  I assigned rock=0, paper=1 and scissors=2.
        // Then I return the value back to function playGame().
        // Ref.: http://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
        int n = randomChoice.nextInt(3);
        String computerChoice = "";
        switch (n) {
            case 0: {
                computerChoice = "ROCK";
                break;
            }
            case 1: {
                computerChoice = "PAPER";
                break;
            }
            case 2: {
                computerChoice = "SCISSORS";
                break;
            }
        }
        return computerChoice;
    }

}
