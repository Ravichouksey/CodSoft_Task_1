public class Player {

    // Player Details
    private String name;

    // Game Statistics
    private int score;
    private int highScore;
    private int roundsPlayed;
    private int roundsWon;

    // Constructor
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.highScore = 0;
        this.roundsPlayed = 0;
        this.roundsWon = 0;
    }

    // Get Player Name
    public String getName() {
        return name;
    }

    // Get Current Score
    public int getScore() {
        return score;
    }

    // Add Score
    public void addScore(int points) {
        score += points;

        if (score > highScore) {
            highScore = score;
        }
    }

    // Reset Score
    public void resetScore() {
        score = 0;
    }

    // High Score
    public int getHighScore() {
        return highScore;
    }

    // Rounds Played
    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void incrementRoundsPlayed() {
        roundsPlayed++;
    }

    // Rounds Won
    public int getRoundsWon() {
        return roundsWon;
    }

    public void incrementRoundsWon() {
        roundsWon++;
    }

    // Win Percentage
    public double getWinPercentage() {

        if (roundsPlayed == 0)
            return 0;

        return (roundsWon * 100.0) / roundsPlayed;
    }

    // Show Player Statistics
    public void showStatistics() {

        System.out.println("\n==============================");
        System.out.println("      PLAYER STATISTICS");
        System.out.println("==============================");

        System.out.println("Player Name    : " + name);
        System.out.println("Current Score  : " + score);
        System.out.println("High Score     : " + highScore);
        System.out.println("Rounds Played  : " + roundsPlayed);
        System.out.println("Rounds Won     : " + roundsWon);

        System.out.printf("Win Percentage : %.2f%%\n",
                getWinPercentage());

        System.out.println("==============================");
    }

    // Display Player Details
    @Override
    public String toString() {

        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", highScore=" + highScore +
                ", roundsPlayed=" + roundsPlayed +
                ", roundsWon=" + roundsWon +
                '}';
    }
}