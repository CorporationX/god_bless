package faang.school.godbless.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread[] players = new Thread[5];
        for (int i = 0; i < players.length; ++i) {
            players[i] = new Thread(new Player("Player " + (i + 1), boss));
            players[i].start();
        }
    }
}
