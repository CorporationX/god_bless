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
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    public void leaveBattle() {
        try {
            semaphore.acquire();
            if (currentPlayers == 0) {
                semaphore.release();
                System.out.println("No players fighting");
            }
            currentPlayers--;
            System.out.println("There is room for another one");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}

