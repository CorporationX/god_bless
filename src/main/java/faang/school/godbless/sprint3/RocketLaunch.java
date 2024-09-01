package faang.school.godbless.sprint3;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
public class RocketLaunch {
    private final String id;
    @Getter
    private LocalDateTime launchStartTime;

    public void start() {
        try {
            long delay = Duration.between(LocalDateTime.now(), launchStartTime).toMillis();
            if (delay > 0) {
                Thread.sleep(delay);
            }
            outputLaunchStatus("Launching");
            Thread.sleep(500);
            outputLaunchStatus("Launch Successful");
        } catch(InterruptedException e) {
            throw new RuntimeException("Thread interrupted: " + id);
        }
    }

    private void outputLaunchStatus(String status) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = launchStartTime.format(formatter);
        System.out.printf("[%s] - %s: %s%n", formattedDateTime, status, id);
    }
}
