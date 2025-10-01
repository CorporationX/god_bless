package school.faang.bjs2_90446;


public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
                wait();
            } catch (InterruptedException e) {
                System.out.println(player.getName() + " был прерван во время ожидания.");
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению с боссом!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение с боссом!");
        notify();
    }
}
