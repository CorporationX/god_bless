package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting for empty slot.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " has joint the battle.");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " left the battle");
        notifyAll();
    }

}
