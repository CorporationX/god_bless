package school.faang.bjs2_90329;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = true;

    void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Проигрывание включено");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Проигрывание приостановлено");
            } else {
                System.out.println("Проигрывание на паузе");

            }
        }
    }

    void skip() {
        synchronized (lock) {
            System.out.println("Текущий трек пропущен, запустили следующий");
        }
    }

    void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Вернулись к предыдущему треку, не запущено");
            } else {
                System.out.println("Вернулись к предыдущему треку, запустили его");
            }
        }
    }
}
