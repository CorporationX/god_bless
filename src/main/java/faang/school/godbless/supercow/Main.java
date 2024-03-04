package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);
        final int countPlayers = 4;
        Player[] players = new Player[countPlayers];

        for (int i = 0; i < countPlayers; i++) {
            players[i] = new Player("Player "+ i, boss);
            players[i].start();
        }

        for (int i = 0; i < countPlayers; i++) {
            players[i].join();
        }
    }
}
