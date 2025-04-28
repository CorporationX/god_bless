package school.faang.bjs2_73487;

import lombok.Data;

import java.util.concurrent.Semaphore;

@Data
public class Boss {

    private int maxPlayers;
    private int currentPlayers;
    private final Semaphore semaphore;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.semaphore = new Semaphore(maxPlayers);
    }

    public void joinBattle() {
        try {
            semaphore.acquire();
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
            } else {
                System.out.println("All places are taken");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public void leaveBattle() {
        try {
            if (currentPlayers == 0) {
                semaphore.release();
                System.out.println("No players fighting");
            }
            currentPlayers--;
            System.out.println("There is room for another one");
        } finally {
            semaphore.release();
        }
    }
}

