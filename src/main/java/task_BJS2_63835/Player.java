package task_BJS2_63835;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Player {
    private final Object lock = new Object();
    private boolean isPlaying;

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

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("музыка остановлена");
            } else {
                System.out.println("музыка уже выключена");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("следующий трек включен");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("предыдущий трек включен");
        }
    }
}
