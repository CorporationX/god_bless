package school.faang.task_49728;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " wait!");
                wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " has joined the battle!");
        }
    }

    public void leaveBattle(Player player) throws InterruptedException {
        synchronized (this) {
            currentPlayers--;
            System.out.println(player.getName() + " has left the battle!");
            notify();
        }
    }

}
