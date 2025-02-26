package school.faang.bjs2_61890;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {

    private boolean isPlaying;
    private final Object lock = new Object();
    private static final int TIME_SLEEP = 1000;

    public void play() {
        if (!isPlaying) {
            synchronized (lock) {
                doAction();
                isPlaying = true;
                System.out.println("Музыка играет!");
            }
        } else {
            System.out.println("Плеер занят");
        }
    }

    public void pause() {
        doAction();
        if (isPlaying) {
            synchronized (lock) {
                isPlaying = false;
                System.out.println("Трек поставлен на паузу");
            }
        } else {
            System.out.println("Метод pause не выполнен. Плеер не запущен");
        }
    }

    public void skip() {
        doAction();
        if (isPlaying) {
            synchronized (lock) {
                System.out.println("Плеер переключен на следующий трек");
            }
        } else {
            System.out.println("Метод skip не выполнен. Плеер не запущен");
        }
    }

    public void previous() {
        doAction();
        if (isPlaying) {
            synchronized (lock) {
                System.out.println("Плеер переключен на предыдущий трек");
            }
        } else {
            System.out.println("Метод previous не выполнен. Плеер не запущен");
        }
    }

    private void doAction() {
        try {
            Thread.sleep(TIME_SLEEP);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
