import java.awt.Toolkit;
import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    // ==========================
    // Random Number Generator
    // ==========================
    public static int generateRandomNumber(int min, int max) {

        return random.nextInt(max - min + 1) + min;

    }

    // ==========================
    // Beep Sound
    // ==========================
    public static void beep() {

        Toolkit.getDefaultToolkit().beep();

    }

    // ==========================
    // Pause Program
    // ==========================
    public static void pause(int milliseconds) {

        try {

            Thread.sleep(milliseconds);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

        }

    }

    // ==========================
    // Clear Console
    // ==========================
    public static void clearScreen() {

        try {

            if (System.getProperty("os.name").contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();

            } else {

                System.out.print("\033[H\033[2J");
                System.out.flush();

            }

        } catch (Exception e) {

            System.out.println();

        }

    }

    // ==========================
    // Countdown
    // ==========================
    public static void countdown(int seconds) {

        System.out.print("Starting in ");

        for (int i = seconds; i >= 1; i--) {

            System.out.print(i + "... ");

            pause(1000);

        }

        System.out.println("GO!");

    }

    // ==========================
    // Lucky Round
    // ==========================
    public static boolean isLuckyRound() {

        return random.nextInt(100) < 20;

    }

    // ==========================
    // Bonus Round
    // ==========================
    public static boolean isBonusRound() {

        return random.nextInt(100) < 15;

    }

    // ==========================
    // Decorative Line
    // ==========================
    public static void line() {

        System.out.println("===================================================");

    }

    // ==========================
    // Center Title
    // ==========================
    public static void title(String title) {

        line();
        System.out.println(title.toUpperCase());
        line();

    }

    // ==========================
    // Welcome Message
    // ==========================
    public static void welcome(String playerName) {

        title("Welcome");

        System.out.println("Hello " + playerName + "!");
        System.out.println("Best of Luck!");

        line();

    }

    // ==========================
    // Exit Message
    // ==========================
    public static void goodbye(String playerName) {

        title("Thank You");

        System.out.println("See you again, " + playerName + "!");
        System.out.println("Have a Great Day!");

        line();

    }

    // ==========================
    // Validate Guess
    // ==========================
    public static boolean isValidGuess(int guess, int min, int max) {

        return guess >= min && guess <= max;

    }

    // ==========================
    // Progress Bar
    // ==========================
    public static void showProgressBar(int current, int total) {

        int percent = (current * 100) / total;

        int bars = percent / 5;

        System.out.print("Progress : [");

        for (int i = 0; i < 20; i++) {

            if (i < bars)
                System.out.print("█");
            else
                System.out.print("░");

        }

        System.out.println("] " + percent + "%");

    }

    // ==========================
    // Stars
    // ==========================
    public static void printStars(int count) {

        for (int i = 0; i < count; i++) {

            System.out.print("⭐");

        }

        System.out.println();

    }

    // ==========================
    // Hearts
    // ==========================
    public static void printHearts(int lives) {

        System.out.print("Lives : ");

        for (int i = 0; i < lives; i++) {

            System.out.print("❤ ");

        }

        System.out.println();

    }

}