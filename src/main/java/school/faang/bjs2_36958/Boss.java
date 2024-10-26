package school.faang.bjs2_36958;

import lombok.NonNull;

public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        if (maxPlayers <= 0) {
            throw new IllegalArgumentException("a boss cannot have a maximum of players less than or equal to zero");
        }
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(@NonNull Player player) {
        if (currentPlayers >= maxPlayers) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        new Thread(() -> player.participateInBattle(this)).start();
        System.out.println(player + " join battle");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        notify();
        System.out.println(player + " leave battle");
    }
}
