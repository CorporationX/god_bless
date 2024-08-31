package faang.school.godbless.dolbahlop.multithreading.synchronization;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Boss {
    private int maxPlayer;
    private int currentPlayer;

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayer >= maxPlayer) {
                System.out.println(player.getName() + " can't join the battle. Limit of players has been reached");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                currentPlayer++;
                System.out.println(player.getName() + " has joined the battle");
            }
        }
    }

    public void battleProcess(Player player) {
        try {
            Thread.sleep(new Random().nextInt(5000) + 3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        leaveBattle(player);
    }

    private synchronized void leaveBattle(Player player) {
        currentPlayer--;
        System.out.println(player.getName() + " has finished the battle");
        notifyAll();
    }
}
