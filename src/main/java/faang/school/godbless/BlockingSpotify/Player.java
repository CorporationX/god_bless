package faang.school.godbless.BlockingSpotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Трек сейчaс проигрывается в потоке " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Трек на паузе в потоке " + Thread.currentThread().getName());
            }
        }
    }

    public void skip() {        // пропускать
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Пропускаем трек в потоке " + Thread.currentThread().getName());
            }
        }
    }

    public void previous() {        // предыдущий
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Предыдущий трек в потоке " + Thread.currentThread().getName());
            }
        }
    }
}
