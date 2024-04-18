package faang.school.godbless.bjs2_5555;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RocketLaunch {

    private String startName;
    private LocalDateTime startLaunch;


    public synchronized void launch() {
        try {
            long timeBeforeStart = (startLaunch.getSecond() - LocalDateTime.now().getSecond()) * 1000;
            Thread.sleep(timeBeforeStart);
            System.out.println("\nLaunch " + startName + " start...");
            Thread.sleep(1000);
            System.out.println("Start time: " + LocalDateTime.now());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
