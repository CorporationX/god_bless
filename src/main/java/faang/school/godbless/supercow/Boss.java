package faang.school.godbless.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (maxPlayers <= currentPlayers) {
            try {
                System.out.println(player.getName() + " is waiting to join the battle.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " has joined the battle. Current players: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " has left the battle. Current players: " + currentPlayers);
        notifyAll();
    }
}
