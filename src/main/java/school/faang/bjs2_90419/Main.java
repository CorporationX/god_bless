package school.faang.bjs2_90419;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Runnable playerTask = () -> {
            Player player = new Player(Thread.currentThread().getName());
            try {
                player.doBattle(boss);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(playerTask, "Player-" + i);
            t.start();
        }
    }
}
