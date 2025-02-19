package school.faang.supercow;

public class App {
    private static final int MAX_PLAYERS = 3;
    private static final Player[] players = {
            new Player("Игрок1"),
            new Player("Игрок2"),
            new Player("Игрок3"),
            new Player("Игрок4"),
            new Player("Игрок5")
    };

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        for (Player player : players) {
            new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
