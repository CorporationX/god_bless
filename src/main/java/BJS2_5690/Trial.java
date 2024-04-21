package BJS2_5690;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " проходит испытания " + trialName);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println(knightName + " провалил испытание " + trialName);
            throw new RuntimeException();
        }
        System.out.println(knightName + " успешно завершил испытание " + trialName);
    }
}
