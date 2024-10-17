package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private String bossName;
    private int maxPlayers;
    private int currentPlayers = 0;

    public Boss(String name, int maxPlayers) {
        this.bossName = name;
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединился к бою!");
    }

    public synchronized void endBattle() {
        currentPlayers--;
        notify();
    }
}
