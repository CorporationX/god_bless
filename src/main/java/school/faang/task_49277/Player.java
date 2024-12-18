package school.faang.task_49277;

public class Player {

    private static final Object LOCK = new Object();
    public static boolean isPlaying = false;

    public static void play() {
        synchronized (LOCK) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("музыка воспроизводится");
            }
            System.out.println("музыка играет");
        }
    }

    public static void pause() {
        synchronized (LOCK) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("музыка поствлена на паузу");
            }
            System.out.println("музыка уже на паузе");
        }
    }

    public static void skip() {
        synchronized (LOCK) {
            System.out.println("пропустить трек");
        }
    }

    public static void previous() {
        synchronized (LOCK) {
            System.out.println("вернуться к предыдущему треку.");
        }
    }
}