package school.faang.spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " is playing =" + isPlaying);
                System.out.println("Трэк играет ");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " is playing =" + isPlaying);
                System.out.println("Трэк на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " is playing =" + isPlaying);
            System.out.println("Следуюй трэк ");
        }
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println(Thread.currentThread().getName() + " is playing =" + isPlaying);
            System.out.println("Предыдущий трэк ");
        }
    }
}