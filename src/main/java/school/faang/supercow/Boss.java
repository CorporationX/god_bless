package school.faang.supercow;

public class Boss {
    private String name;
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("One player " + player.getName() +  " joined the battle");
            currentPlayers += 1;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            currentPlayers -= 1;
            System.out.println("One player " + player.getName() + " left the battle");
            this.notifyAll();
        }
    }
}
