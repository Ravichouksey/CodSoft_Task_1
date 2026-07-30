import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Colors.printTitle();

        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();

        Player player = new Player(name);

        Leaderboard leaderboard = new Leaderboard();
        Game game = new Game(player);

        boolean running = true;

        while (running) {

            Colors.printMenu();

            System.out.print("Choose Option : ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(Colors.RED + "Invalid Input!" + Colors.RESET);
                continue;
            }

            switch (choice) {

                case 1:
                    game.startGame();
                    break;

                case 2:
                    printRules();
                    break;

                case 3:
                    leaderboard.showLeaderboard();
                    break;

                case 4:
                    player.showStatistics();
                    break;

                case 5:
                    System.out.println();

                    System.out.println(Colors.GREEN +
                            "Thank you for playing " +
                            player.getName() +
                            " 😊"
                            + Colors.RESET);

                    running = false;
                    break;

                default:
                    System.out.println(Colors.RED +
                            "Invalid Choice!"
                            + Colors.RESET);

            }

        }

        sc.close();

    }

    private static void printRules() {

        System.out.println();

        System.out.println(Colors.YELLOW +
                "=========== RULES ===========" +
                Colors.RESET);

        System.out.println("1. Guess the secret number.");

        System.out.println("2. Difficulty decides range and attempts.");

        System.out.println("3. Wrong guess loses one life.");

        System.out.println("4. Hint unlocks after some attempts.");

        System.out.println("5. Less attempts = More Score.");

        System.out.println("6. Lucky Round gives Double Score.");

        System.out.println("7. Bonus Round available after winning.");

        System.out.println("8. High Score is automatically saved.");

        System.out.println("9. Achievements unlock while playing.");

        System.out.println("=============================");

    }

}
