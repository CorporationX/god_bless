package school.faang.m1.thread.supercow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);
        Thread[] threads = new Thread[4];
        threads[0] = new Thread(() -> {
            Player player = new Player("1");
            player.doBattle(boss);
        });
        threads[1] = new Thread(() -> {
            Player player = new Player("2");
            player.doBattle(boss);
        });
        threads[2] = new Thread(() -> {
            Player player = new Player("3");
            player.doBattle(boss);
        });
        threads[3] = new Thread(() -> {
            Player player = new Player("4");
            player.doBattle(boss);
        });

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
