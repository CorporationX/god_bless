package school.faang.BJS2_36862_Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Boss {
    private static final int BATTLE_DURATION = 5_000;

    private int maxPlayers;
    private int currentPlayers;
    private Object lock;
    ExecutorService service;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        lock = new Object();
        service = Executors.newSingleThreadExecutor();
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.printf("There are no free places for %s to participate in the battle!\n", player.getName());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new IllegalStateException(
                            String.format(
                                    "Player's (%s) thread %s was interrupted while waiting for joining the battle.",
                                    player.getName(), Thread.currentThread().getName()
                            ),
                            e
                    );
                }
            }
            currentPlayers++;
            System.out.printf("Player %s has joined the battle.\n", player.getName());
            if (currentPlayers == maxPlayers) {
                service.submit(this::startBattle);
            }
        }
    }

    private void startBattle() {
        System.out.println("The battle has started!");
        try {
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            throw new IllegalStateException(
                    String.format("Battle thread %s was interrupted while its execution!", Thread.currentThread().getName()),
                    e
            );
        } finally {
            resetBattle();
        }
    }

    public void shutdownService() {
        service.shutdown();
    }

    private void resetBattle() {
        synchronized (lock) {
            System.out.println("The battle is over! Current players leave the battle!");
            currentPlayers = 0;
            lock.notifyAll();
        }
    }
}
