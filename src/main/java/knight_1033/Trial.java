package knight_1033;

import lombok.Data;

@Data

public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    //    @SneakyThrows
    public void run() {

        System.out.println(Thread.currentThread().getName() + " Началось испытание " + trialName);
        try {
            Thread.sleep(100);
            System.out.println("Испытание - '" + trialName + "' завершено");
        } catch (InterruptedException e) {
            throw new RuntimeException("Испытание - '" + trialName + "' не пройдено");
        }
    }
}