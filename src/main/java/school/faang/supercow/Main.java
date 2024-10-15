package school.faang.supercow;

public class Main {
    private static final int MAX_PLAYERS_TO_BOSS = 2;
    private static final int PLAYERS = 3;
    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS_TO_BOSS);
        Player[] players = new Player[PLAYERS];
        Thread[] threads = new Thread[PLAYERS];

        for (int i =0; i < PLAYERS; i++) {
            players[i] = new Player("Player " + i);
        }

        for (int i = 0; i < PLAYERS; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> players[finalI].startBattle(boss));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}