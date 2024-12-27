package school.faang.supercowbjs49732;

public class GameTest {
    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        Player[] players = {
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5")
        };

        for (Player player : players) {
            new Thread(() -> player.startBattle(boss)).start();
        }
    }
}
