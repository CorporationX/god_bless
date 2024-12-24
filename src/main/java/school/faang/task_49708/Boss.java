package school.faang.task_49708;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " ждет своей очереди для сражения с боссом.");
                wait();
            } catch (InterruptedException e) {
                System.out.println(player.getName() + " был прерван.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению. Игроков в бою: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение. Свободных слотов: " + (maxPlayers - currentPlayers));
        notify();
    }
}
