package faang.school.godbless.blocking_spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Включаю музыку");
                isPlaying = true;
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Ставлю паузу");
                isPlaying = false;
            } else {
                System.out.println("Музыка и так не играет");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропускаю трэк");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущий трэк");
        }
    }
}
