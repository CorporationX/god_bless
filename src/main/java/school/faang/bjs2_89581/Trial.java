package school.faang.bjs2_89581;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " has started trial: " + trialName);
            Thread.sleep(3000);
            System.out.println(knightName + " has finished trial: " + trialName);
        } catch (InterruptedException e) {
            System.out.println(knightName + " has interrupted trial: " + trialName);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
