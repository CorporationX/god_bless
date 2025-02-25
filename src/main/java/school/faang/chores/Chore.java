package school.faang.chores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @SneakyThrows
    @Override
    public void run() {
        log.info("{} is doing {}", Thread.currentThread().getName(), title);
        Thread.sleep(1000);
    }
}
