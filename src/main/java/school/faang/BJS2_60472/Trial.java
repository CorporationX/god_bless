package school.faang.BJS2_60472;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;


    @Override
    public void run() {
        try {
            System.out.println(trialName + " началось");
            Thread.sleep(5000); // Задержка в 1 секунду
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
