package school.faang.bjs2_90350;

public class Player {
    private volatile boolean isPlaying = false;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Трек запущен");
            } else {
                System.out.println("Трек уже проигрывается");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Трек поставлен на паузу");
            } else {
                System.out.println("Трек уже на паузе");
            }
        }
    }

    public void skip() {
        System.out.println("Запущен следующий трек");
    }

    public void previous() {
        System.out.println("Запущен предыдущий трек");
    }
}
