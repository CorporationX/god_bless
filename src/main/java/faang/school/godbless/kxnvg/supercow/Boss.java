package faang.school.godbless.kxnvg.supercow;

public class Boss {

    private String name;
    private int maxPlayers;
    private int currentPlayers;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            synchronized (this) {
                currentPlayers++;
            }
            System.out.println(player.getName() + " приступил к сражению с БОССОМ " + name);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(player.getName() + " закончил битву с БОССОМ " + name);
            currentPlayers--;
            notify();
        }
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
