package faang.school.godbless.Sprint4.task4_Synch;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < maxPlayers) {
            addPlayer(player);
        } else {
            try {
                wait();
                addPlayer(player);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void addPlayer(Player player) {
        currentPlayers++;
        System.out.println("Player " + player.getName() + " joined the battle " + Thread.currentThread().getName());
    }

    public synchronized void endOneBattle(Player player) {
        System.out.println("Player " + player.getName() + " end the battle " + Thread.currentThread().getName());
        currentPlayers--;
        notify();
    }



}
