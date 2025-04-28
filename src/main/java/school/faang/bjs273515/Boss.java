package school.faang.bjs273515;

public class Boss {

    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers >= maxPlayers) {
                try {
                    System.out.println("Wait in queue");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Error while waiting in queue");
                }
            } else {
                currentPlayers++;
                System.out.println(player.getName() + " is battling!!!");
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName() + " is finished battling");
            lock.notify();
        }
    }
}
