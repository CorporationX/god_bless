package task_BJS2_63835;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Synchronized;


@Data
@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

    @Synchronized
    public void play() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("музыка уже играет");
            } else {
                isPlaying = true;
                System.out.println("музыка включена");
            }
        }
    }

    @Synchronized
    public synchronized void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("музыка остановлена");
            } else {
                System.out.println("музыка уже выключена");
            }
        }
    }

    @Synchronized
    public void skip() {
        synchronized (lock) {
            System.out.println("следующий трек включен");
        }
    }

    @Synchronized
    public void previous() {
        synchronized (lock) {
            System.out.println("предыдущий трек включен");
        }
    }
}
