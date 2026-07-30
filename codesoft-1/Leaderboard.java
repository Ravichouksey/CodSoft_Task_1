import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leaderboard {

    private ArrayList<Player> players;

    public Leaderboard() {
        players = new ArrayList<>();
    }

    // Add player to leaderboard
    public void addPlayer(Player player) {

        players.add(player);

        sortLeaderboard();

        if (players.size() > 10) {
            players.remove(players.size() - 1);
        }
    }

    // Sort leaderboard in descending order of score
    private void sortLeaderboard() {

        Collections.sort(players, new Comparator<Player>() {

            @Override
            public int compare(Player p1, Player p2) {

                return Integer.compare(
                        p2.getScore(),
                        p1.getScore());

            }

        });

    }

    // Display leaderboard
    public void showLeaderboard() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println("               LEADERBOARD");
        System.out.println("==============================================");

        if (players.isEmpty()) {

            System.out.println("No Records Found!");

        } else {

            System.out.printf("%-5s %-20s %-10s%n",
                    "Rank",
                    "Player",
                    "Score");

            System.out.println("----------------------------------------------");

            int rank = 1;

            for (Player p : players) {

                System.out.printf("%-5d %-20s %-10d%n",
                        rank,
                        p.getName(),
                        p.getScore());

                rank++;
            }

        }

        System.out.println("==============================================");
    }

    // Get Top Player
    public Player getTopPlayer() {

        if (players.isEmpty()) {

            return null;

        }

        return players.get(0);
    }

    // Find Player
    public Player searchPlayer(String name) {

        for (Player p : players) {

            if (p.getName().equalsIgnoreCase(name)) {

                return p;

            }

        }

        return null;
    }

    // Remove Player
    public void removePlayer(String name) {

        Player player = searchPlayer(name);

        if (player != null) {

            players.remove(player);

        }

    }

    // Clear Leaderboard
    public void clearLeaderboard() {

        players.clear();

    }

    // Total Players
    public int totalPlayers() {

        return players.size();

    }

    // Return player list (used by FileManager)
    public ArrayList<Player> getPlayers() {

        return players;

    }

}