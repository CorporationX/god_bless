package faang.school.godbless.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers == maxPlayers) {
            wait();
        }

        currentPlayers++;
        System.out.println(player.getName() + " joined the battle");
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getPlayerName() + " completed the battle");
        notify();
    }

}
