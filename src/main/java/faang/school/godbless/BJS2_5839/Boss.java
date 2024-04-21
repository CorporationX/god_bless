package faang.school.godbless.BJS2_5839;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers;

    public void joinBattle(Player player) {
        synchronized (currentPlayers) {
            if (currentPlayers.size() == maxPlayers) {
                try {
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
                System.out.println(player.getName() + " is can't join to fight");
            } else {
                currentPlayers.add(player);
                System.out.println(player.getName() + " is joining to fight");
            }
        }
    }

    public void fightWithBoss(Player player) {
        synchronized (currentPlayers) {
            System.out.println(player.getName() + " is fighting with boss");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            System.out.println(player.getName() + "is stopping fight");
            if (!currentPlayers.isEmpty()) {
                currentPlayers.add(player);
                System.out.println(player.getName() + " is leaving fight");
            }
        }
    }
}
