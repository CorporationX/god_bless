package school.faang.spacex;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private static final int TIME_TO_WORK = 1000;
    private String name;
    private LocalDateTime timeToStart;

    public void launch() {
        try {
            LocalDateTime now = LocalDateTime.now();
            if (now.isBefore(timeToStart)) {
                long waitTime = timeToStart.toEpochSecond(ZoneOffset.ofHours(0)) - now.toEpochSecond(ZoneOffset.ofHours(0));

                Thread.sleep(waitTime * 1000);
            }
            System.out.println(LocalDateTime.now() + ": Ракета " + name + " запускается " + Thread.currentThread().getName());

            Thread.sleep(TIME_TO_WORK);

            System.out.println(LocalDateTime.now() + ": Ракета " + name + " запущена " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("Поток прерван " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
