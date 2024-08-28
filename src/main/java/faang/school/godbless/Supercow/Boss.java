package faang.school.godbless.Supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting for a slot to fight the boss");
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle! Current players: " + currentPlayers);

    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
            System.out.println(player.getName() + " left the battle! Current players: " + currentPlayers);
            notify();
        }
    }
}
