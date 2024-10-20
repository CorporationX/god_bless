package school.faang.BJS2_36862_Supercow;

public class Boss {
    private static final int BATTLE_DURATION = 5_000;

    private int maxPlayers;
    private int currentPlayers;
    private Object lock;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        lock = new Object();
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.println("There are no free places to participate in the battle!");
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
                startBattle();
            }
        }
    }

    private void startBattle() {
        System.out.println("The battle has been started!");
        try {
            Thread.sleep(BATTLE_DURATION);
        } catch (InterruptedException e) {
            throw new IllegalStateException(
                    String.format("Thread %s was interrupted while its execution!", Thread.currentThread().getName()),
                    e
            );
        } finally {
            System.out.println("The battle has been ended! Current players leave the battle!");
            currentPlayers = 0;
            lock.notifyAll();
        }
    }
}
