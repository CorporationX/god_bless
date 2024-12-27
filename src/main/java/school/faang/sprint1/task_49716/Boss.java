package school.faang.sprint1.task_49716;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    private final Object joinInGame = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению с боссом!");
    }

    public synchronized void leaveBoss(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул поле боя");
        notify();
    }
}
