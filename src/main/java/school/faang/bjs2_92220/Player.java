package school.faang.bjs2_92220;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Player {
    private final String lock;
    private AtomicBoolean isPlaying = new AtomicBoolean();

    public Player(String lock) {
        this.lock = lock;
    }

    public void play() {
        synchronized (lock) {
            isPlaying.getAndSet(true);
            log.info("Пользователь - {}, Включилась музыка? {}", Thread.currentThread().getName(), isPlaying.get());
        }
    }

    public void pause() {
        synchronized (lock) {
            isPlaying.getAndSet(false);
            log.info("Пользователь - {}, Поставил Музыку на паузу, Она включенна? {}",
                    Thread.currentThread().getName(), isPlaying.get());
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying.getAndSet(false);
            log.info("Пользователь - {}, Переключили музыку вперед, Играет музыка? - {}",
                    Thread.currentThread().getName(), isPlaying.get());
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying.getAndSet(false);
            log.info("Пользователь - {}, Переключили музыку назад, Играет ли музыка? {}",
                    Thread.currentThread().getName(), isPlaying.get());
        }
    }
}
