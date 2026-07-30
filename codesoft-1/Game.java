import java.util.Random;
import java.util.Scanner;

public class Game {

    private Player player;
    private Leaderboard leaderboard;
    private Random random;
    private Scanner scanner;

    public Game(Player player) {
        this.player = player;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void startGame() {

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("\n==============================");
            System.out.println("       NEW GAME STARTED");
            System.out.println("==============================");

            int maxNumber = 100;
            int maxAttempts = 7;

            int difficulty = chooseDifficulty();

            switch (difficulty) {

                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;

                case 3:
                    maxNumber = 500;
                    maxAttempts = 10;
                    break;

                default:
                    System.out.println("Invalid choice. Medium selected.");
            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            int attemptsLeft = maxAttempts;
            boolean guessed = false;

            player.incrementRoundsPlayed();

            while (attemptsLeft > 0) {

                System.out.println("\nLives Remaining : " + attemptsLeft);
                System.out.print("Enter your guess (1-" + maxNumber + "): ");

                int guess;

                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                    scanner.nextLine();
                    continue;
                }

                if (guess == secretNumber) {

                    guessed = true;

                    int score = attemptsLeft * 10;

                    player.addScore(score);

                    player.incrementRoundsWon();

                    System.out.println("\nCongratulations " + player.getName() + "!");
                    System.out.println("Correct Guess!");
                    System.out.println("You earned " + score + " points.");

                    break;

                } else if (guess > secretNumber) {

                    System.out.println("Too High!");

                } else {

                    System.out.println("Too Low!");

                }

                attemptsLeft--;

                if (attemptsLeft == 3) {

                    System.out.print("\nDo you want a Hint? (yes/no): ");

                    String choice = scanner.next();

                    if (choice.equalsIgnoreCase("yes")) {

                        giveHint(secretNumber);

                    } else {

                        System.out.println("Okay! No hint will be provided.");

                    }

                }

            }

            if (!guessed) {

                System.out.println("\nGame Over!");
                System.out.println("Correct Number was : " + secretNumber);

            }

            showStatistics();

            System.out.print("\nPlay Again? (yes/no): ");

            String choice = scanner.next();

            playAgain = choice.equalsIgnoreCase("yes");

        }

    }

    private int chooseDifficulty() {

        System.out.println("\nChoose Difficulty");

        System.out.println("1. Easy (1-50)");

        System.out.println("2. Medium (1-100)");

        System.out.println("3. Hard (1-500)");

        System.out.print("Enter Choice : ");

        return scanner.nextInt();

    }

    private void giveHint(int number) {

        System.out.println("\n******** HINT ********");

        if (number % 2 == 0) {

            System.out.println("The number is EVEN.");

        } else {

            System.out.println("The number is ODD.");

        }

        if (number > 50) {

            System.out.println("The number is greater than 50.");

        } else {

            System.out.println("The number is less than or equal to 50.");

        }

        System.out.println("**********************");

    }

    private void showStatistics() {

        System.out.println("\n==============================");
        System.out.println("Player : " + player.getName());

        System.out.println("Rounds Played : " + player.getRoundsPlayed());

        System.out.println("Rounds Won : " + player.getRoundsWon());

        System.out.println("Total Score : " + player.getScore());

        double winPercentage = 0;

        if (player.getRoundsPlayed() > 0) {

            winPercentage = (player.getRoundsWon() * 100.0)
                    / player.getRoundsPlayed();

        }

        System.out.printf("Win Percentage : %.2f%%\n", winPercentage);

        System.out.println("==============================");

    }

}