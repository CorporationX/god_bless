package Spotify;


public class Player {
    private final static Object lock = new Object();
    private static boolean isPlaying = false;

    public static void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Start play music");
            }
        }
    }

    public static void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Music is pause");
            }
        }
    }

    public static void skip() {
        synchronized (lock) {
            System.out.println("Music is skip");
        }
    }

    public static void previous() {
        synchronized (lock) {
            System.out.println("Music is previous");
        }
    }
}
