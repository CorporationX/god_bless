package faang.school.godbless.synchronization.supercow;

import java.util.Random;

public class Boss {
    private final String name;
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        try {
            synchronized (this) {
                while (currentPlayers == maxPlayers) {
                    System.out.printf("Игрок [%s] попал в очередь на босса %s -- [%s]\n",
                            player.getName(), name, Thread.currentThread().getName());
                    this.wait();
                    System.out.printf("Игрок [%s] проснулся (босс %s)\n", player.getName(), name);
                }

                currentPlayers++;
            }
            int battleDurationInSec = new Random().nextInt(1, 10);
            System.out.printf("Игрок [%s] начал сражение с боссом %s eta = %d -- [%s]\n",
                    player.getName(), name, battleDurationInSec, Thread.currentThread().getName());

            Thread.sleep(battleDurationInSec * 1000L);

            System.out.printf("Игрок [%s] завершил сражение с боссом %s\n", player.getName(), name);

            synchronized (this) {
                currentPlayers--;
                this.notify();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
