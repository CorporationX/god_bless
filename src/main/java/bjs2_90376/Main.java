package bjs2_90376;

public class Main {

    private static final int MAX_PLAYERS = 2;
    private static final int ONLINE_PLAYERS = 6;

    public static void main(String[] args) {

        Boss boss = new Boss(MAX_PLAYERS);

        for (int i = 1; i <= ONLINE_PLAYERS; i++) {
            int playerIndex = i;
            new Thread(() -> new Player("Игрок " + playerIndex).doBattle(boss)).start();
        }

    }
}
