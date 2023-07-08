package faang.school.godbless.supercow;

import lombok.Data;
@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            System.out.println(player.getName() + " joined the battle " + "[" + Thread.currentThread().getName() + "]");
            currentPlayers++;
        } else {
            System.out.println(player.getName() + " is waiting " + "[" + Thread.currentThread().getName() + "]");
            currentPlayers++;
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void endOneBattle(Player player) {
        System.out.println(player.getName() + " end the battle " + "[" + Thread.currentThread().getName() + "]");
        currentPlayers--;
        notifyAll();
    }
}
