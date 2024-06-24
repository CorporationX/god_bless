package faang.school.godbless.multithreading.supercow;

import java.util.LinkedList;
import java.util.Queue;

public class Boss {
    private final int timeOneBattle;

    private final int timeFullBattle;
    private final Object lock = new Object();
    private final int maxPlayers;
    private final Queue<Player> currentPlayers = new LinkedList<>();


    public Boss(int timeOneBattle, int maxPlayers) {
        this.timeOneBattle = timeOneBattle;
        this.timeFullBattle = 5 * timeOneBattle;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized(lock) {
            if (currentPlayers.size() >= maxPlayers) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers.offer(player);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void deJoinBattle() {
        long startTime = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - startTime >= timeOneBattle) {
                synchronized (lock) {
                    if (!currentPlayers.isEmpty()) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Игрок " + currentPlayers.poll().name() + " завершил сражение с боссом");
                        startTime = System.currentTimeMillis();
                        lock.notify();
                    }

                    if (System.currentTimeMillis() - startTime >= timeFullBattle) {
                        System.out.println("Сражение с боссом окончено");
                        return;
                    }
                }
            }
        }
    }
}
