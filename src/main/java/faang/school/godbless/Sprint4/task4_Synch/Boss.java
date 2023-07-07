package faang.school.godbless.Sprint4.task4_Synch;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            currentPlayers++;
            System.out.println(player.getName() + " joined the battle " + "[" + Thread.currentThread().getName() + "]");
        } else {
            try {
                wait();
                currentPlayers++;
                System.out.println(player.getName() + " is waiting " + "[" + Thread.currentThread().getName() + "]");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void endOneBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " end the battle " + "[" + Thread.currentThread().getName() + "]");
        notify();
    }


}
