package school.faang.bjs2_90329;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыка уже играет");
            } else {
                isPlaying = true;
                System.out.println("Проигрывание включено");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Проигрывание приостановлено");
            } else {
                System.out.println("Проигрывание уже паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Текущий трек пропущен, запустили следующий");
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Вернулись к предыдущему треку, запустили его");
            } else {
                System.out.println("Вернулись к предыдущему треку, не запущено");
            }
        }
    }
}
