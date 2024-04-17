package faang.school.godbless.tournamentatkinglanding;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Рыцаь " + knightName + " выполняет задание " + trialName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        System.out.println("Рыцаь " + knightName + " выполнил задание " + trialName);
    }
}
