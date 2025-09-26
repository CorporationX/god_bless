package school.faang.bjs2_90403;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {

    private final String name;
    private final int maxPlayers = 2;
    private int currentPlayers = 0;

    private final Object bossLock = new Object();

    public Boss(String name) {
        this.name = name;
    }

    public void joinBattle(Player player) {
        synchronized (bossLock) {
            while (getMaxPlayers() - getCurrentPlayers() == 0) {
                try {
                    System.out.println(getName() + " has his hands full. " +
                            player.getName() + " will have to wait for a bit ...");
                    bossLock.wait(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(player.getName() + " has enter battle with " + getName());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (bossLock) {
            System.out.println(player.getName() + " has left the battle with " + getName());
            currentPlayers--;
            bossLock.notifyAll();
        }
    }
}
