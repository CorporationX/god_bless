package school.faang.bjs248062;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("%s started %s%n", knightName, trialName);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s finished %s%n", knightName, trialName);
    }

}
