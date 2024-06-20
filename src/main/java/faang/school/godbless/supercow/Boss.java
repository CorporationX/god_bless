package faang.school.godbless.supercow;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread was interrupted " + e.getMessage());
            }
        }

        currentPlayers++;
        System.out.println(player.getName() + " joined the battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " left the battle");

        this.notify();
    }
}
