package faang.school.godbless.sprint4.multithreading_parallelism_thread.task9;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial extends Thread {

    private String knightName;

    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " выполняет испытание " + trialName);
    }
}
