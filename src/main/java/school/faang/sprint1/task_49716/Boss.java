package school.faang.sprint1.task_49716;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " лобби забито");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединяется к сражению с боссом");
    }

    public synchronized void leaveBoss(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул поле боя");
        notify();
    }
}
