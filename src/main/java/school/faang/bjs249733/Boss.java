package school.faang.bjs249733;

public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " is waiting to join battle");
                wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " has just joined to battle");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(player.getName() + " was interrupted while waiting to join battle");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " has just finished his fight with boss");
        notify();
    }

}
