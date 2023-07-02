package faang.school.godbless.parallelismAndThread.spaceX;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Getter
@AllArgsConstructor
public class RocketLaunch implements Runnable {
    @Setter
    private String name;
    @Setter
    private LocalDateTime time;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm:ss");

    public void launch() {
        System.out.println("Начало запуска ракеты: " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ракета " + name + " успешно запущена в " + dateTimeFormatter.format(time));
    }

    @Override
    public void run() {
        long duration = ChronoUnit.MILLIS.between(LocalDateTime.now(), time);
        try {
            Thread.sleep(duration);
            launch();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
