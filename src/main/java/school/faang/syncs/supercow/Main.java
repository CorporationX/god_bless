package school.faang.syncs.supercow;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);

        for (int i = 0; i <= 20; i++) {
            Player player = new Player("Player №" + i);

            new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
