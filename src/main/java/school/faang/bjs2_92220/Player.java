package school.faang.bjs2_92220;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Player {
    private final Object lock;
    private final AtomicBoolean isPlaying = new AtomicBoolean();

    public Player(String lock) {
        this.lock = lock;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying.get()) {
                isPlaying.getAndSet(true);
                log.info("Пользователь - {}, Включает музыку", Thread.currentThread().getName());
            } else {
                log.info("Пользователь - {}, Музыка уже включена", Thread.currentThread().getName());
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying.get()) {
                isPlaying.getAndSet(false);
                log.info("Пользователь - {}, Поставил Музыку на паузу",
                        Thread.currentThread().getName());
            } else {
                log.info("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying.getAndSet(true);
            log.info("Пользователь - {}, Переключили музыку вперед, Играет музыка? - {}",
                    Thread.currentThread().getName(), isPlaying.get());
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying.getAndSet(true);
            log.info("Пользователь - {}, Переключили музыку назад, Играет ли музыка? {}",
                    Thread.currentThread().getName(), isPlaying.get());
        }
    }
}
