package supercow;

public class Boss {
    private final Object lock = new Object();
    private int maxPlayers;
    private int currentPlayers;
    private String name;

    public String getName() {
        return name;
    }

    public Boss(String name, int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.name = name;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " fight against " + getName());
    }

    public synchronized void finishBattle() {
        currentPlayers--;
        notify();
    }
}
