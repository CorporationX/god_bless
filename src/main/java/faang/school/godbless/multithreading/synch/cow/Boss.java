package faang.school.godbless.multithreading.synch.cow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        System.out.println("Joining " + player.getName() + " player");

        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println("current players >= max players, waiting...");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        currentPlayers++;
        System.out.println(player.getName() + " joined boss fight");
    }


    public synchronized void endBattle(Player player) {
        currentPlayers--;
        System.out.println("Player " + player.getName() + " finished boss fight");
        notify();
    }
}
