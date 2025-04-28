package school.faang.bjs273162;

public class Player {
    private boolean isPlaying = false;
    private Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + "включил трек");
            } else {
                System.out.println(Thread.currentThread().getName() + " не смог включить трек. ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " приостановил трек");
            } else {
                System.out.println(Thread.currentThread().getName() + " не смог поставить трек на паузу");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + "пропустил трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " включил предыдущий трек");
        }
    }
}
