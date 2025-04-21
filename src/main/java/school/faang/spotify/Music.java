package school.faang.spotify;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Music {
    private final List<Thread> threads = new ArrayList<>();
    private final Thread userOne = new Thread(() -> {
        new Player().play();
        log.info("В потоке {} запустили плеер", Thread.currentThread().getName());
    });

    private final Thread userTwo = new Thread(() -> {
        new Player().skip();
        log.info("В потоке {} пропустили трек", Thread.currentThread().getName());
    });

    private final Thread userThree = new Thread(() -> {
        new Player().pause();
        log.info("В потоке {} поставили музыку на паузу", Thread.currentThread().getName());
    });

    private final Thread userFour = new Thread(() -> {
        new Player().previous();
        log.info("В потоке {} вернулись на предыдущий трек", Thread.currentThread().getName());
    });

    public void addThread() {
        threads.add(userOne);
        threads.add(userTwo);
        threads.add(userThree);
        threads.add(userFour);
    }
}