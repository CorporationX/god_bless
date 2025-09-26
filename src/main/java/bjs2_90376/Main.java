package bjs2_90376;

public class Main {

    public static void main(String[] args) {

        int maxPlayers = 2;
        int onlinePlayers = 6;

        Boss boss = new Boss(maxPlayers);

        for (int i = 1; i <= onlinePlayers; i++) {
            int playerIndex = i;
            new Thread(() -> new Player("Игрок " + playerIndex).doBattle(boss)).start();
        }

    }
}
