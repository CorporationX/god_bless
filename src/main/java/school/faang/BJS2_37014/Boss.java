package school.faang.BJS2_37014;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " ждет, пока освободится слот для сражения.");
                wait();
            } catch (InterruptedException e) {
                System.out.println(player.getName() + " был прерван.");
                e.printStackTrace();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к сражению. Текущие игроки: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покинул сражение. Текущие игроки: " + currentPlayers);
        notify();
    }
}
