package faang.school.godbless.thread.spaceX;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime time;

    @SneakyThrows
    public void launch() {
        long timeout = Duration.between(LocalDateTime.now(), time).toMillis();
        System.out.println("Запуск через " + timeout / 1000 + " секунд! " + name + ", двигатель на старт!");
        TimeUnit.MILLISECONDS.sleep(timeout);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Поехали!");
    }
}
