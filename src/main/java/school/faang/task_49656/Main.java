package school.faang.task_49656;

public class Main {
    private static final int PLAYER_DISCONNECTING_DELAY = 1000;

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss("Oracle", 5);

        for (int i = 0; i < 6; i++) {
            Player player = new Player("Player" + i);
            new Thread(() -> player.startBattle(boss)).start();
        }

        Thread.sleep(PLAYER_DISCONNECTING_DELAY);
        boss.getCurrentPlayers().get(0).endBattle(boss);
    }
}
