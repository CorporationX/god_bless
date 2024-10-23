package supercow;

public class Boss {
    private final int maximumPlayers;
    private int fightingPlayers;

    public Boss(int maximumPlayers) {
        this.maximumPlayers = maximumPlayers;
    }

    public synchronized void goIntoBattle(Player player) {
        while (fightingPlayers >= maximumPlayers) {
            try {
                System.out.println(player.getName()
                        + " ждет свободного места для присоединения с сражению");
                wait();
            } catch (InterruptedException error) {
                Thread.currentThread().interrupt();
                System.out.println(player.getName() + " был прерван");
            }
        }
        fightingPlayers++;
        System.out.println(player.getName()
                + " присоединился к сражению вместе с "
                + "Воин "
                + fightingPlayers
                + ". Ещё могут присоединиться "
                + (maximumPlayers - fightingPlayers)
                + " атакующих"
        );
    }

    public synchronized void leaveBattle(Player player) {
        fightingPlayers--;
        System.out.println(player.getName()
                + " вышел из сражения непобежденным. "
                + "Сейчас сражаются: "
                + fightingPlayers
                + ". Ещё могут присоединиться "
                + (maximumPlayers - fightingPlayers)
                + " атакующих");
        notify();
    }
}
