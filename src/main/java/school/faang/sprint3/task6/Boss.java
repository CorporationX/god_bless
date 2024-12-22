package school.faang.sprint3.task6;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.setMaxPlayers(maxPlayers);
    }

    public synchronized void joinBattle(Player player) {
        if (this.getCurrentPlayers() < this.getMaxPlayers()) {
            this.setCurrentPlayers(this.getCurrentPlayers() + 1);
            System.out.println(player.getName() + " присоединился к бою");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.fillInStackTrace();
            }
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (this.getCurrentPlayers() > 0) {
            this.setCurrentPlayers(this.getCurrentPlayers() - 1);

            System.out.println(player.getName() + " покинул бой");
            notify();
        }
    }
}
