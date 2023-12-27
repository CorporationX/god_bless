package faang.school.godbless.block_notify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Запуск проигрывания");
                isPlaying = true;
            } else {
                System.out.println("Трек уже проигрывается");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Приостанавливаем проигрывание");
                isPlaying = false;
            } else {
                System.out.println("Проигрывание уже приостановлено");
            }
        }

    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Пропускаем трек");
            } else {
                System.out.println("Не можем пропустить трек. Проигрывание на паузе");
            }
        }

    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Включаем предыдущий трек");
            } else {
                System.out.println("Проигрывание на паузе");
            }

        }

    }
}
