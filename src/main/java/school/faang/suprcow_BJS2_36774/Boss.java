package school.faang.suprcow_BJS2_36774;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        try {
            while (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " waiting");
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        currentPlayers++;
        System.out.println("Player: " + player.getName() + " join to a battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        notify();
        System.out.println("Player " + player.getName() + " left the battle!");
    }
}
