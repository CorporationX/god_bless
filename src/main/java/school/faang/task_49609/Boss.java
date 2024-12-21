package school.faang.task_49609;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        String playerName = player.getName();
        while (currentPlayers >= maxPlayers) {
            System.out.println(playerName
                    + " ждет свободного слота для сражения с боссом.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Произошла ошибка");
            }
        }
        currentPlayers++;
        System.out.println(playerName + " присоединился к сражению с боссом!");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " завершил сражение с боссом!");
        notify();
    }
}
