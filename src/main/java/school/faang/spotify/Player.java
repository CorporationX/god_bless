package school.faang.spotify;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            if (isPlaying) {
                isPlaying = true;
                System.out.println("музыка начала играть");
            } else {
                System.out.println("музыка продолжает играть");

            }
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            if (!isPlaying) {
                isPlaying = false;
                System.out.println("музыка прекратить играть");
            } else {
                System.out.println("музыка продолжать не играть");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("пропустить трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("вернуться к предыдущему треку");
        }
    }
}
