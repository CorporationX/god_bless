package school.faang.sprint3.bjs2_81259;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RocketLaunch {
    public static final int LAUNCH_DURATION = 1000;

    private String name;
    private LocalDateTime launchTime;

    public void launch() {
        try {
            System.out.printf("Начало запуска (%s)\n", name);
            Thread.sleep(LAUNCH_DURATION);
            System.out.printf("Завершение запуска (%s)\n", name);
        } catch (InterruptedException e) {
            System.out.printf("Запуск: %s\n", name);
            throw new RuntimeException(e);
        }

    }
}
