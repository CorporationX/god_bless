package faang.school.godbless.SkyNet;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class Robot {
    private final String target;

    public void attack() {
        synchronized (target) {
            LocalDateTime start = LocalDateTime.now();
            try {
                Thread.sleep(1000);
                System.out.println(target + " was under attack from " + start + " to " + LocalDateTime.now());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
