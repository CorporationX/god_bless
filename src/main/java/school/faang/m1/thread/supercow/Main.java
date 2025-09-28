package school.faang.m1.thread.supercow;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);

        Thread[] threads = new Thread[4];
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            threads[i] = new Thread(() -> {
                Player player = new Player("P" + finalI);
                player.doBattle(boss);
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
