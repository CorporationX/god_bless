package school.faang;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        final Logger log = LoggerFactory.getLogger(Music.class);

        Thread userFirst;
        userFirst = new Thread(() -> {
            player.play();
        });

        Thread userSecond;
        userSecond = new Thread(() -> {
            player.skip();
        });

        Thread userThird;
        userThird = new Thread(() -> {
            player.pause();
        });

        Thread userFour;
        userFour = new Thread(() -> {
            player.previous();
        });

        userFirst.start();
        userSecond.start();
        userThird.start();
        userFour.start();

        try {
            userFirst.join();
            userSecond.join();
            userThird.join();
            userFour.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Произошла ошибка в потоках. Текущая операция: {}", Thread.currentThread().getName(), e);
        }
    }
}
