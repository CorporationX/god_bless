package faang.school.godbless.multithreading.wow;


import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class Player {
    private String name;
    private int level;
    private int experience;
    private static final int EXP_FACTOR = 100;
    private static AtomicBoolean gameIsRunning = new AtomicBoolean(true);

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
        ExecutorService levelUpThread = Executors.newSingleThreadExecutor();
        levelUpThread.execute(this::levelUp);
        levelUpThread.shutdown();
    }

    private synchronized void levelUp() {
        while (gameIsRunning.get()) {
            while (experience < (level + 1) * EXP_FACTOR) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            experience -= (level + 1) * EXP_FACTOR;
            level++;
        }
    }

    public void completeQuest(Quest quest) {
        System.out.printf("%s starts quest %s\n", name, quest.getName());
        try {
            TimeUnit.SECONDS.sleep(quest.getDifficulty());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this) {
            experience += quest.getReward();
            notifyAll();
        }
    }

    public static void endGame() {
        gameIsRunning.set(false);
    }
}
