package school.faang.synchronization.supercow;

public class Boss {
    private int MAX_PLAYERS;
    private int CURRENT_PLAYERS;

    public Boss(int maxPlayers) {
        this.MAX_PLAYERS = maxPlayers;
        this.CURRENT_PLAYERS = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (CURRENT_PLAYERS >= MAX_PLAYERS) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Party is full");
            }
        }
        CURRENT_PLAYERS++;
        System.out.println(player.getName() + " joined to Battle");
    }

    public synchronized void leaveBattle(Player player) {
        CURRENT_PLAYERS--;
        System.out.println(player.getName() + " finished fight");
        notify();
    }
}





