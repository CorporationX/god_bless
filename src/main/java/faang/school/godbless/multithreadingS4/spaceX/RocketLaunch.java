package faang.school.godbless.multithreadingS4.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime startTime;

    public void launch() {
        try {
            Thread.currentThread().setName("Thread for " + name);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.printf("%s has been interrupted%n", Thread.currentThread().getName());
        }
        System.out.printf("%s launched at %s%n", name, startTime);
    }
}
