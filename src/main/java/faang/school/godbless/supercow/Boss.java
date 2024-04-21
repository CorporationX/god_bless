package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers = new ArrayList<>();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) {
        if (maxPlayers == currentPlayers.size()) {
            try {
                System.out.println("Wait " + player.getName() + " until there is a free space");
                currentPlayers.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentPlayers.add(player);
            System.out.println(player.getName() + " successfully added");
        }
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers.contains(player)) {
            currentPlayers.remove(player);
            System.out.println(player.getName() + " leaved the boss");
            currentPlayers.notify();
        } else {
            System.out.println("This player does not participate in the battle");
        }
    }
}
