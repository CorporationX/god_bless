package faang.school.godbless.supercow;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if(currentPlayers < maxPlayers) {
            currentPlayers++;
            System.out.println("Player " + player.getName() + " join battle");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("Player " + player.getName() + "leave battle");
        notifyAll();
    }
}
