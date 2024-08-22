package faang.school.godbless.BJS2_24199;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " is waiting for the battle");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle. Current players: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " left the battle. Current players: " + currentPlayers);
        notify();
    }

}
