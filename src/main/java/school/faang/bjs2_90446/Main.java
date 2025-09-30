package school.faang.bjs2_90446;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player[] players = new Player[] {
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        };

        Thread[] threads = new Thread[] {
                new Thread(() -> players[0].doBattle(boss)),
                new Thread(() -> players[1].doBattle(boss)),
                new Thread(() -> players[2].doBattle(boss)),
                new Thread(() -> players[3].doBattle(boss)),
        };

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
