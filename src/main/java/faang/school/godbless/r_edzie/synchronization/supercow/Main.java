package faang.school.godbless.r_edzie.synchronization.supercow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int bossMaxPlayers = 3;
        int playersCount = 11;

        Boss boss = new Boss(bossMaxPlayers);
        Player[] players = new Player[playersCount];

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Игрок " + i, boss);
            players[i].start();
        }

        for (Player player : players) {
            player.join();
        }
    }
}
