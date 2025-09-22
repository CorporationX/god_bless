package school.faang.bjs2_90292;

public class Player {

    private static final Object lock = new Object();
    private static boolean isPlaying;

    public static void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println(Thread.currentThread().getName() + " Музыка уже играет");
            } else {
                isPlaying = true;
                System.out.println(Thread.currentThread().getName() + " Музыка воспроизводится");
            }

        }
    }

    public static void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println(Thread.currentThread().getName() + " Музыка поставлена на паузу");
            } else {
                System.out.println(Thread.currentThread().getName() + " Музыка уже на паузе");
            }
        }
    }

    public static void skip() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " Следующий трек");
        }
    }

    public static void previous() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " Предыдущий трек");
        }
    }
}
