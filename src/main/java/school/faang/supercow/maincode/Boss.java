package school.faang.supercow.maincode;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers, int currentPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinPlayer(Player player) {
        try {
            if (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " ждет свободного слота для сражения с боссом");
                wait();
            }
            currentPlayers++;
            System.out.println(player.getName() + " вступил в сражение с боссом");
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул битву");
        notify();
    }
}
