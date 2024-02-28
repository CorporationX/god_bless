package faang.school.godbless.r_edzie.synchronization.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers >= maxPlayers) {
            wait();
        }

        currentPlayers++;
        System.out.println(player.getNickname() + " joined");
    }

    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getNickname() + " left");
        notify();
    }
}
