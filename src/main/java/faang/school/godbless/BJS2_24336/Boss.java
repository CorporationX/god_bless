package faang.school.godbless.BJS2_24336;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers >= maxPlayers) {
                System.out.println(player.getName() + " couldn't join battle because every spot in this fight is taken");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined battle with boss");
        }
    }

    public void processPlayerBattle(Player player) {
        try {
            Thread.sleep(new Random().nextInt(7001) + 3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        leaveBattle(player);
    }

    private synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " finished the battle with boss");
        notifyAll();
    }
}
