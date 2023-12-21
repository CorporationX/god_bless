package faang.school.godbless.multithreading.parallelism.kingLandingTournament;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private Knight knight;
    private String trialName;

    @Override
    public void run() {
        int taskTime = knight.getTaskTime();
        System.out.println(knight.getName() + " began trial - " + trialName + "!");
        try {
            Thread.sleep(taskTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(knight.getName() + " passed successfully trial - " + trialName + "!");
    }
}
