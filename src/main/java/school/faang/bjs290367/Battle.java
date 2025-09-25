package school.faang.bjs290367;

public class Battle {
    private static final int COUNT_THREADS = 7;

    public static void main(String[] args) {
        Boss boss = new Boss(5);
        // Create and start multiple players
        for (int i = 0; i < COUNT_THREADS; i++) {
            Player player = new Player();
            player.setName("Player" + i);
            new Thread(() -> player.doBattle(boss)).start();
        }
    }
}

