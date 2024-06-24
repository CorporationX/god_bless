package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_6_royal_harbor;

import java.util.Random;

public record Trial(String knightName, String trialName) implements Runnable {

    @Override
    public void run() {
        try {
            System.out.printf("%s проходит испытание: %s\n", knightName, trialName);
            Thread.sleep(new Random().nextInt(3000, 5000));
            System.out.printf("%s прошёл испытание. отдыхает.\n", knightName);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
