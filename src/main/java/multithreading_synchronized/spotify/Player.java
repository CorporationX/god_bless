package multithreading_synchronized.spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        synchronized (lock) {
            System.out.println("Воспроизведение музыки");
            isPlaying = true;
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Музыка поставлена на паузу");
                isPlaying = false;
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Переключить эту песню");
            }
        }
    }

    public void previous() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Вернуть предыдущую песню");
            }
        }
    }
}
