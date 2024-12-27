package school.faang.task_49366;


public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Музыкаь включена");
            } else {
                System.out.println("Музыка уже играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Музыка поставлена на паузу");
            } else {
                System.out.println("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Включен следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Включен предыдущий трек");
        }
    }
}
