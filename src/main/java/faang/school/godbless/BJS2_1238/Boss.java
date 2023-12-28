package faang.school.godbless.BJS2_1238;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting for a slot to join the battle.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        currentPlayers++;
        System.out.println(player.getName() + " joined the battle. Current players: " + currentPlayers);
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println("A player " + player.getName() + " finished the battle. Current players: " + currentPlayers);
        notify();
    }
}