package school.faang.bjs273463;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " ждет свободный слот");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(player.getName() + " вызвал ошибку InterruptedException");
                return;
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " вступает в бой");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покидает бой");
        notify();
    }
}
