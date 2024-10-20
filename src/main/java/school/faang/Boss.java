package school.faang;

import lombok.NonNull;

public class Boss {
    private final int maxPlayers = 5;
    private int currentPlayers;

    public synchronized void joinBattle(@NonNull Player player) {
            if (currentPlayers >= maxPlayers) {
                try {
                    System.out.println(player.getName() + " wait..");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.println(player.getName() + " come to fight");
    }

    public synchronized void leaveBattle(Player player) {
            System.out.println(player.getName() + " leave bro");
            currentPlayers--;
            notify();
    }
}
