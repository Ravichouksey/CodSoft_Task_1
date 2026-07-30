import java.util.ArrayList;

public class AchievementManager {

    private ArrayList<String> achievements;

    public AchievementManager() {
        achievements = new ArrayList<>();
    }

    // Check and unlock achievements
    public void checkAchievements(Player player) {

        unlockFirstWin(player);
        unlockScoreAchievements(player);
        unlockRoundsAchievements(player);
        unlockWinRateAchievement(player);
    }

    // First Win Achievement
    private void unlockFirstWin(Player player) {

        if (player.getRoundsWon() >= 1 &&
                !achievements.contains("First Victory")) {

            achievements.add("First Victory");
            System.out.println("\n🏆 Achievement Unlocked!");
            System.out.println("⭐ First Victory");
        }
    }

    // Score Achievements
    private void unlockScoreAchievements(Player player) {

        int score = player.getScore();

        if (score >= 100 &&
                !achievements.contains("Beginner")) {

            achievements.add("Beginner");
            System.out.println("🥉 Beginner Achievement Unlocked!");
        }

        if (score >= 300 &&
                !achievements.contains("Pro Gamer")) {

            achievements.add("Pro Gamer");
            System.out.println("🥈 Pro Gamer Achievement Unlocked!");
        }

        if (score >= 500 &&
                !achievements.contains("Expert")) {

            achievements.add("Expert");
            System.out.println("🥇 Expert Achievement Unlocked!");
        }

        if (score >= 1000 &&
                !achievements.contains("Legend")) {

            achievements.add("Legend");
            System.out.println("👑 Legend Achievement Unlocked!");
        }
    }

    // Rounds Won Achievements
    private void unlockRoundsAchievements(Player player) {

        int wins = player.getRoundsWon();

        if (wins >= 5 &&
                !achievements.contains("Winner")) {

            achievements.add("Winner");
            System.out.println("🏅 Winner Achievement Unlocked!");
        }

        if (wins >= 10 &&
                !achievements.contains("Champion")) {

            achievements.add("Champion");
            System.out.println("🏆 Champion Achievement Unlocked!");
        }

        if (wins >= 20 &&
                !achievements.contains("Master")) {

            achievements.add("Master");
            System.out.println("🔥 Master Achievement Unlocked!");
        }
    }

    // Win Percentage Achievement
    private void unlockWinRateAchievement(Player player) {

        if (player.getRoundsPlayed() == 0)
            return;

        double winRate = player.getWinPercentage();

        if (winRate >= 80 &&
                !achievements.contains("Sharp Shooter")) {

            achievements.add("Sharp Shooter");
            System.out.println("🎯 Sharp Shooter Achievement Unlocked!");
        }
    }

    // Display All Achievements
    public void showAchievements() {

        System.out.println("\n==============================");
        System.out.println("      ACHIEVEMENTS");
        System.out.println("==============================");

        if (achievements.isEmpty()) {

            System.out.println("No achievements unlocked yet.");

        } else {

            for (int i = 0; i < achievements.size(); i++) {

                System.out.println((i + 1) + ". " + achievements.get(i));

            }

        }

        System.out.println("==============================");
    }

    // Total Achievements
    public int totalAchievements() {

        return achievements.size();
    }

    // Check if player has an achievement
    public boolean hasAchievement(String achievement) {

        return achievements.contains(achievement);
    }

    // Reset achievements
    public void resetAchievements() {

        achievements.clear();
    }

}