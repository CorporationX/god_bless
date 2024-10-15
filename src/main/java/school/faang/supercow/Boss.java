package school.faang.supercow;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
                wait();
            } catch (InterruptedException e) {
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
