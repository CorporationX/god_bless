package supercow;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println("The player " + player.getName() + " is waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("The player " + player.getName() + " was interrupted while waiting");
            }
        }
        currentPlayers++;
        System.out.println("The player " + player.getName() + " has joined the battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("The player" + player.getName() + " has completed the battle");
        notify();
    }
}
