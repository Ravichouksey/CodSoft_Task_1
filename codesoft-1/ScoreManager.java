public class ScoreManager {

    // Calculate score based on remaining attempts
    public int calculateScore(int attemptsLeft) {

        return attemptsLeft * 10;
    }

    // Bonus score
    public int bonusScore() {

        return 100;
    }

    // Lucky round score (Double Score)
    public int luckyRoundScore(int score) {

        return score * 2;
    }

    // Show current score
    public void displayCurrentScore(Player player) {

        System.out.println("\n==========================");
        System.out.println("Current Score : " + player.getScore());
        System.out.println("==========================");
    }

    // Show final result
    public void displayFinalResult(Player player) {

        System.out.println("\n==================================");
        System.out.println("          FINAL RESULT");
        System.out.println("==================================");

        System.out.println("Player Name     : " + player.getName());
        System.out.println("Rounds Played   : " + player.getRoundsPlayed());
        System.out.println("Rounds Won      : " + player.getRoundsWon());

        System.out.printf("Win Percentage  : %.2f%%\n",
                player.getWinPercentage());

        System.out.println("Final Score     : " + player.getScore());
        System.out.println("Highest Score   : " + player.getHighScore());

        System.out.println("==================================");
    }

    // Display stars according to score
    public void showStars(int score) {

        System.out.print("Rating : ");

        if (score >= 500) {

            System.out.println("★★★★★");

        } else if (score >= 350) {

            System.out.println("★★★★☆");

        } else if (score >= 200) {

            System.out.println("★★★☆☆");

        } else if (score >= 100) {

            System.out.println("★★☆☆☆");

        } else {

            System.out.println("★☆☆☆☆");

        }

    }

    // Achievement Message
    public void checkAchievement(Player player) {

        int score = player.getScore();

        if (score >= 1000) {

            System.out.println("🏆 Achievement Unlocked : Legend");

        } else if (score >= 700) {

            System.out.println("🥇 Achievement Unlocked : Master Player");

        } else if (score >= 500) {

            System.out.println("🥈 Achievement Unlocked : Expert");

        } else if (score >= 300) {

            System.out.println("🥉 Achievement Unlocked : Pro Gamer");

        } else if (score >= 100) {

            System.out.println("🎖 Achievement Unlocked : Beginner");

        }

    }

    // Display Progress Bar
    public void progressBar(int current, int total) {

        int percent = (current * 100) / total;

        System.out.print("Progress : [");

        int bars = percent / 10;

        for (int i = 0; i < 10; i++) {

            if (i < bars)
                System.out.print("█");
            else
                System.out.print("░");
        }

        System.out.println("] " + percent + "%");
    }

}
