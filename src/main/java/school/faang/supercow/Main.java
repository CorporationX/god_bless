package school.faang.supercow;


public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Thread[] playersThreads = new Thread[5];
        for (int i = 0; i < playersThreads.length; i++) {
            final int number = i + 1;
            playersThreads[i] = new Thread(() -> {
                Player player = new Player("Player " + number);
                player.startBattle(boss);
            });
            playersThreads[i].start();
        }
        for (Thread thread : playersThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
