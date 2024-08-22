package faang.school.godbless.BJS2_23547;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String name;
    private String trialName;

    @Override
    public void run() {
        System.out.println(name + " starts " + trialName);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " completes " + trialName);
    }
}
