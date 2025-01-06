package school.faang.task_49337;

import lombok.Data;

@Data
public class Player {
    private static final Object lock = new Object();
    private static boolean isPlaying;

    public static void play() {
        synchronized (lock) {
            if (isPlaying == false) {
                isPlaying = true;
                System.out.println("Воспроизведение музыки началось");
            } else {
                System.out.println("Музыка уже воспроизводится");
            }
        }
    }

    public static void pause() {
        synchronized (lock) {
            if (isPlaying == true) {
                isPlaying = false;
                System.out.println("Воспроизведение музыки остановлено");
            } else {
                System.out.println("Музыка уже не воспроизводится");
            }
        }
    }

    public static void skip() {
        synchronized (lock) {
            System.out.println("Следующая композиция");
        }
    }

    public static void previous() {
        synchronized (lock) {
            System.out.println("Вернуться назад");
        }
    }
}
