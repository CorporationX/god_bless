package school.faang.task_49179;

public class Player {
    private boolean isPlaying = false;
    private Object lock = new Object();

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыка включена!");
            } else {
                System.out.println("Музыка уже играет!");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка приостановлена!");
            } else {
                System.out.println("Музыка уже приостановлена");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Слушаем следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Слушаем предыдущий трек");
        }
    }
}