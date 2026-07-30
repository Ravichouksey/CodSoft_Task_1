import java.util.Random;

public class HintSystem {

    private Random random;

    public HintSystem() {
        random = new Random();
    }

    // Display a random hint
    public void showHint(int secretNumber) {

        int hintType = random.nextInt(5);

        System.out.println("\n========== HINT ==========");

        switch (hintType) {

            case 0:
                if (secretNumber % 2 == 0)
                    System.out.println("The number is EVEN.");
                else
                    System.out.println("The number is ODD.");
                break;

            case 1:
                if (secretNumber > 50)
                    System.out.println("The number is GREATER than 50.");
                else
                    System.out.println("The number is LESS THAN OR EQUAL TO 50.");
                break;

            case 2:
                if (isPrime(secretNumber))
                    System.out.println("The number is a PRIME number.");
                else
                    System.out.println("The number is NOT a PRIME number.");
                break;

            case 3:
                System.out.println("The number is divisible by "
                        + greatestFactor(secretNumber));

                break;

            case 4:

                int lower = (secretNumber / 10) * 10;
                int upper = lower + 10;

                System.out.println("The number lies between "
                        + lower + " and " + upper);

                break;

        }

        System.out.println("==========================");
    }

    // Hint after every wrong guess
    public void compareHint(int guess, int secretNumber) {

        int difference = Math.abs(secretNumber - guess);

        if (difference <= 5) {

            System.out.println("🔥 Very Close!");

        } else if (difference <= 10) {

            System.out.println("😊 Close!");

        } else if (difference <= 20) {

            System.out.println("🙂 You're getting closer.");

        } else {

            System.out.println("😅 Far Away.");

        }

    }

    // Prime Number Check
    private boolean isPrime(int number) {

        if (number <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {

            if (number % i == 0)
                return false;

        }

        return true;
    }

    // Greatest Factor
    private int greatestFactor(int number) {

        for (int i = number / 2; i >= 2; i--) {

            if (number % i == 0)
                return i;

        }

        return 1;
    }

    // First Digit Hint
    public void firstDigitHint(int number) {

        String str = String.valueOf(number);

        System.out.println("First Digit : " + str.charAt(0));

    }

    // Last Digit Hint
    public void lastDigitHint(int number) {

        System.out.println("Last Digit : " + (number % 10));

    }

    // Range Hint
    public void rangeHint(int number) {

        int start = (number / 20) * 20;
        int end = start + 20;

        System.out.println("The number is between "
                + start + " and " + end);

    }

}
