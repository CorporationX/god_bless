package faang.school.godbless.multithreading.task_6.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;


    @Override
    public void run() {
        System.out.println(knightName + " начал выполнение " + trialName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(trialName + " не было завершено");
        }
        System.out.println(knightName + " закончил выполнение " + trialName);
    }
}
