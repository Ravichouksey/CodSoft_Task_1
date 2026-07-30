public class Colors {

    // Reset
    public static final String RESET = "\u001B[0m";

    // Regular Colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bold Colors
    public static final String BOLD_RED = "\u001B[1;31m";
    public static final String BOLD_GREEN = "\u001B[1;32m";
    public static final String BOLD_YELLOW = "\u001B[1;33m";
    public static final String BOLD_BLUE = "\u001B[1;34m";
    public static final String BOLD_PURPLE = "\u001B[1;35m";
    public static final String BOLD_CYAN = "\u001B[1;36m";
    public static final String BOLD_WHITE = "\u001B[1;37m";

    // Welcome Title
    public static void printTitle() {

        System.out.println(BOLD_CYAN);
        System.out.println("******************************************************");
        System.out.println("*                                                    *");
        System.out.println("*              NUMBER GUESSING GAME                  *");
        System.out.println("*                                                    *");
        System.out.println("*          Developed Using Core Java                 *");
        System.out.println("*                                                    *");
        System.out.println("******************************************************");
        System.out.println(RESET);

    }

    // Main Menu
    public static void printMenu() {

        System.out.println(BOLD_BLUE);
        System.out.println("\n================ MAIN MENU ================");
        System.out.println("1. Play Game");
        System.out.println("2. Game Rules");
        System.out.println("3. Leaderboard");
        System.out.println("4. Player Statistics");
        System.out.println("5. Exit");
        System.out.println("===========================================");
        System.out.print("Enter Choice : ");
        System.out.print(RESET);

    }

    // Winning Message
    public static void printWin() {

        System.out.println(BOLD_GREEN);
        System.out.println("\n🎉 CONGRATULATIONS!");
        System.out.println("You guessed the correct number!");
        System.out.println(RESET);

    }

    // Losing Message
    public static void printLose() {

        System.out.println(BOLD_RED);
        System.out.println("\nGAME OVER!");
        System.out.println("Better Luck Next Time!");
        System.out.println(RESET);

    }

    // Hint
    public static void printHint(String hint) {

        System.out.println(BOLD_YELLOW);
        System.out.println("\n💡 HINT : " + hint);
        System.out.println(RESET);

    }

    // Error
    public static void printError(String message) {

        System.out.println(BOLD_RED);
        System.out.println(" * " + message);
        System.out.println(RESET);

    }

    // Success
    public static void printSuccess(String message) {

        System.out.println(BOLD_GREEN);
        System.out.println("✔ " + message);
        System.out.println(RESET);

    }

    // Information
    public static void printInfo(String message) {

        System.out.println(BOLD_CYAN);
        System.out.println(message);
        System.out.println(RESET);

    }

    // Hearts (Lives)
    public static void printLives(int lives) {

        System.out.print(BOLD_RED + "Lives : ");

        for (int i = 1; i <= lives; i++) {

            System.out.print(" heart ");

        }

        System.out.println(RESET);

    }

    // Progress Bar
    public static void printProgress(int current, int total) {

        int percent = (current * 100) / total;

        int bars = percent / 10;

        System.out.print(BOLD_PURPLE + "Progress : [");

        for (int i = 0; i < 10; i++) {

            if (i < bars)
                System.out.print("█");
            else
                System.out.print("░");

        }

        System.out.println("] " + percent + "%" + RESET);

    }

    // Divider
    public static void divider() {

        System.out.println(BOLD_WHITE +
                "--------------------------------------------------"
                + RESET);

    }

    // Score Card
    public static void scoreCard(Player player) {

        System.out.println(BOLD_GREEN);
        System.out.println("\n============== SCORE CARD ==============");

        System.out.println("Player        : " + player.getName());
        System.out.println("Score         : " + player.getScore());
        System.out.println("High Score    : " + player.getHighScore());
        System.out.println("Rounds Played : " + player.getRoundsPlayed());
        System.out.println("Rounds Won    : " + player.getRoundsWon());

        System.out.printf("Win Rate      : %.2f%%\n",
                player.getWinPercentage());

        System.out.println("========================================");
        System.out.println(RESET);

    }

}
