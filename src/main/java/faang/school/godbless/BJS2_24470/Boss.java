package faang.school.godbless.BJS2_24470;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final String name;
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        battle(player);
        currentPlayers++;
    }

    private void battle(Player player) {
        Thread battle = new Thread(() -> {
            System.out.println(player.getName() + " starts startBattle with boss: " + getName());
            try {
                Thread.sleep(player.getBattleTime());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(player.getName() + " ends startBattle with boss: " + getName());
            leaveBattle(player);
        });
        battle.start();
    }

    public synchronized void leaveBattle(Player player) {
        System.out.println(player.getName() + " leave this battle with boss " + getName());
        currentPlayers--;
        notify();
    }
}
