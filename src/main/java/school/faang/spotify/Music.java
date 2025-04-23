package school.faang.spotify;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
public class Music {
    private final List<String> music = List.of(
            "Song 1",
            "Song 2",
            "Song 3",
            "Song 4",
            "Song 5",
            "Song 6",
            "Song 7",
            "Song 8",
            "Song 9",
            "Song 10",
            "Song 11",
            "Song 12",
            "Song 13",
            "Song 14",
            "Song 15"
    );

    private final Player player = new Player();

    private final Thread userOne = new Thread(() -> {
        player.play();
        log.info("В потоке {} запустили плеер", Thread.currentThread().getName());
    });

    private final Thread userTwo = new Thread(() -> {
        player.skip();
        log.info("В потоке {} пропустили трек", Thread.currentThread().getName());
    });

    private final Thread userThree = new Thread(() -> {
        player.pause();
        log.info("В потоке {} поставили музыку на паузу", Thread.currentThread().getName());
    });

    private final Thread userFour = new Thread(() -> {
        player.previous();
        log.info("В потоке {} вернулись на предыдущий трек", Thread.currentThread().getName());
    });

    private final List<Thread> userThreads = List.of(
            userOne,
            userTwo,
            userThree,
            userFour
    );
}
// надо установить начальное значение в плейлисте
// команды заставляли передвигаться по плей листу
// отдельно реализовать потоки юзеров в отдельном классе