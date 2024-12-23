package school.faang.task_48919;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class RocketLaunch {
    public static final Integer SLEEP_TIME = 1000;

    private final String name;
    private final LocalDateTime launchTime;

    public void launchRocket() {
        try {
            Thread.sleep(SLEEP_TIME);
            System.out.printf("Запускаем: %s%n", name);
        } catch (InterruptedException e) {
            System.out.println("Ошибка");
        }
    }
}
