package school.faang.sprint3.task49721supercow;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Boss {
    private final Integer maxPlayers;
    private Integer currentPlayers;

    Boss(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (maxPlayers == currentPlayers) {
            player.wait();
        }
        currentPlayers++;
        System.out.printf("%s join to battle %n", player.getName());

    }

    public synchronized void leaveBattle(Player player) {
        this.setCurrentPlayers(this.getCurrentPlayers() - 1);
        System.out.printf("%s completed the battle %n", player.getName());
        this.notifyAll();
    }
}
