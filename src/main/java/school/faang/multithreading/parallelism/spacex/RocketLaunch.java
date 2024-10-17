package school.faang.multithreading.parallelism.spacex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private LocalDateTime launchTime;

    @SneakyThrows
    public void launch() {
        Thread.sleep(1000);
        log.info("Запускается ракета {}", name);
    }
}
