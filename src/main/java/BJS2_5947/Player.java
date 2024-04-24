package BJS2_5947;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                System.out.println("Трек запущен");
                isPlaying = true;
            } else {
                System.out.println("Музыка играет");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                System.out.println("Трек установлен на паузу");
                isPlaying = false;
            } else {
                System.out.println("Трек уже поставлен на паузу");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Переключение трека");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Возврат к предыдущему треку");
        }
    }
}
