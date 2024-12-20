package school.faang.bjs249733;

public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " is waiting to join battle");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " has just joined to battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " has just finished his fight with boss");
        notify();
    }

}
