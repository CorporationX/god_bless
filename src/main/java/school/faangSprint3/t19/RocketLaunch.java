package school.faangSprint3.t19;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RocketLaunch {
    private final String name;
    private final long launchTime;

    public RocketLaunch(String name, LocalDateTime launchDateTime) {
        this.name = name;
        this.launchTime = launchDateTime.atZone(java.time.ZoneId.systemDefault())
                .toInstant().toEpochMilli();
    }

    public void launch() {
        try {
            Thread.sleep(1000);
            System.out.println("Ракета " + name + " запущена в " +
                    LocalDateTime.now());
        } catch (InterruptedException e) {
            System.err.println("Запуск прерван: " + e.getMessage());
        }
    }
}