package faang.school.godbless.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            wait();
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединилися к битве с боссом");
    }

        public synchronized void endBattle() {
        currentPlayers--;
        System.out.println("Player закончил сражение с боссом");
        notifyAll();
    }
}
