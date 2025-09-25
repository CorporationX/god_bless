package school.faang.spotify;

public class Player {
    private Boolean isPlaying = false;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() +  " Запустили воспроизведение музыки");
            } else {
                System.out.println(Thread.currentThread().getName() + " Музыка уже воспроизводится");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " Остановили воспроизведение музыки");
            } else {
                System.out.println(Thread.currentThread().getName() + " Музыка на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " Пропустили трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " Вернулись к предыдущему треку");
        }
    }
}
