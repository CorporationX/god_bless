package school.faang.task_49773;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (player == null) {
            System.out.println("Неизвестный игрок не может присоединиться к сражению.");
            return;
        }
        try {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.name() + " ждет свободного слота для сражения с боссом.");
                wait();
            }
            currentPlayers++;
            System.out.println(player.name() + " присоединился к сражению с боссом!");
        } catch (InterruptedException e) {
            System.out.println(player.name() + " был прерван во время ожидания сражения.");
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (player == null) {
            System.out.println("Неизвестный игрок не может завершить сражение.");
            return;
        }
        currentPlayers--;
        System.out.println(player.name() + " завершил сражение с боссом!");
        notify();
    }
}