package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private static final Integer MAX_SLOT_SIZE = 5;

    private final Object lock;
    private Integer currentPlayers = 0;

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while(currentPlayers >= MAX_SLOT_SIZE) {
                System.out.println("There is no place. Please wait.");
                lock.wait();
            }
        }

        currentPlayers++;
        System.out.println("Player " + player.getName() + " joined this game.");
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println(player.getName()  + " left battle");
            lock.notify();
        }
    }
}
