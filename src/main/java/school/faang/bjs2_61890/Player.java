package school.faang.bjs2_61890;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@AllArgsConstructor
@Getter
public class Player {

    private boolean isPlaying;
    private final Lock lock = new ReentrantLock();

    public void play() {
        if (!isPlaying) {
            synchronized (lock) {
                isPlaying = true;
                System.out.println("Музыка играет!");
            }
        } else {
            System.out.println("Плеер занят");
        }
    }

    public void pause() {
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
        if (isPlaying) {
            synchronized (lock) {
                System.out.println("Плеер переключен на следующий трек");
            }
        } else {
            System.out.println("Метод skip не выполнен. Плеер не запущен");
        }
    }

    public void previous() {
        if (isPlaying) {
            synchronized (lock) {
                System.out.println("Плеер переключен на предыдущий трек");
            }
        } else {
            System.out.println("Метод previous не выполнен. Плеер не запущен");
        }
    }

}
