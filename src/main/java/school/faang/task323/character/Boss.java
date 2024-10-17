package school.faang.task323.character;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                System.out.println(player.getName() + " Ждет");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " join the battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " leave the battle");
        notifyAll();
    }
}
