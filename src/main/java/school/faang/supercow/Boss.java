package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    private final Object lock = new Object();

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.printf("%s ждёт свободного слота...\n", player.getName());
                lock.wait();
            }
            currentPlayers++;
            System.out.printf("%s присоединился к битве! (Сейчас в бою: %d)\n", player.getName(), currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("%s покинул битву. (Сейчас в бою: %d)\n", player.getName(), currentPlayers);
            lock.notify();
        }
    }
}
