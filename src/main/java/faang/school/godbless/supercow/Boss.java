package faang.school.godbless.supercow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private List<Player> currentPlayer;

    public synchronized void joinBattle(@NonNull Player player) {
        if (currentPlayer.size() >= maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayer.add(player);
        System.out.println("Player " + player.getName() + " joined the battle!");
    }


    public synchronized void leaveBattle(@NonNull Player player) {
        if (currentPlayer.contains(player)) {
            currentPlayer.remove(player);
            System.out.println("Player " + player.getName() + " left the battle!");

            this.notify();
        } else {
            throw new IllegalArgumentException("Player " + player.getName() + " is not on the battle!");
        }
    }
}
