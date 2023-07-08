package faang.school.godbless.Supercow;

import lombok.Data;

@Data
public class Boss {
    private int bossLevel;
    private int maxPlayers;
    private int currentPlayers = 0;

    public Boss(int bossLevel, int maxPlayers) {
        this.bossLevel = bossLevel;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers >= maxPlayers) {
                try {
                    System.out.println("Player " + player.getName() + " can't join, it's already too much, poor Boss t.t, wait!");
                    this.wait();
                    currentPlayers++;
                    System.out.println("Player " + player.getName() + " joins this battle");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                currentPlayers++;
                System.out.println("Player " + player.getName() + " joins this battle");
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            currentPlayers--;
            System.out.println("Player " + player.getName() + " leaves this battle");
            this.notifyAll();
        }
    }
}
