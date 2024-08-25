package faang.school.godbless.supercow;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Boss {
    private int maxPlayers;
    private List<Player> curPlayers;

    public Boss(int maxPlayers, List<Player> curPlayers) {
        if (curPlayers.size() > maxPlayers) {
            throw new IllegalArgumentException();
        }
        this.maxPlayers = maxPlayers;
        this.curPlayers = new ArrayList<>(curPlayers);
    }

    public synchronized void joinBattle(Player player) {
        if (curPlayers.size() >= maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("game over");
            }
        }
        curPlayers.add(player);
        System.out.println("player " + player.getName() + " joined to boss");
    }

    public synchronized void leaveBattle(Player player) {
        if (curPlayers.contains(player)) {
            curPlayers.remove(player);
            System.out.println("player " + player.getName() + " leaved from boss");
            this.notify();
        } else {
            System.out.println("player " + player.getName() + " have not battle with boss");
        }
    }
}
