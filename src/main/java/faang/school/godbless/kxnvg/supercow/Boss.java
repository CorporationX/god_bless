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

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.getName() + " ожидает битвы");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println("К игре присоеденилось: " + currentPlayers);
        System.out.println(player.getName() + " приступил к сражению с БОССОМ " + name);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void deletePlayer(Player player) {
        System.out.println(player.getName() + " закончил битву с БОССОМ " + name);
        currentPlayers--;
        notify();
    }
}
