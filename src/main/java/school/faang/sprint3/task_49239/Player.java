package school.faang.sprint3.task_49239;

public class Player {
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            System.out.println(isPlaying ? "Трек уже играет" : "Играет какой-то трек");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            System.out.println(isPlaying ? "Трек поставлен на паузу" : "Трек уже стоит на паузе");
            isPlaying = false;
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Плеер переключен на следующий трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Плеер переключен на предыдущий трек");
        }
    }
}
