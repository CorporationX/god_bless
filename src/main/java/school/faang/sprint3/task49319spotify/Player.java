package school.faang.sprint3.task49319spotify;

public class Player {
    private static final Object lock = new Object();
    private static boolean isPlaying;

    public static void play() {
        synchronized (lock) {
            isPlaying = true;
            System.out.println("Play!");
        }
    }

    public static void pause() {
        synchronized (lock) {
            isPlaying = false;
            System.out.println("Pause");
        }
    }

    public static void skip() {
        synchronized (lock) {
            if (!isPlaying) {
                play();
            }
            System.out.println("Skip");
        }
    }

    public static void previous() {
        synchronized (lock) {
            if (!isPlaying) {
                play();
            }
            System.out.println("Previous");
        }
    }

}
