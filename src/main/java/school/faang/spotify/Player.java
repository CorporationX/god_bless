package school.faang.spotify;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class Player {
    private final AtomicBoolean isPlaying;
    private final Object lock;
    String name;

    public Player(String name, Object lock, AtomicBoolean isPlaying) {
        this.name = name;
        this.isPlaying = isPlaying;
        this.lock = lock;
    }

    public void play() {
        synchronized (lock) {
            if (!isPlaying.get()) {
                isPlaying.set(true);
                System.out.println(Thread.currentThread().getName() + name + " Запустили воспроизведение музыки");
            } else {
                System.out.println(Thread.currentThread().getName() + name + " Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying.get()) {
                isPlaying.set(false);
                System.out.println(Thread.currentThread().getName() + name + " Остановили воспроизведение музыки");
            } else {
                System.out.println(Thread.currentThread().getName() + name + " Музыка на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + name + " Пропустили трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + name + " Вернулись к предыдущему треку");
        }
    }
}
