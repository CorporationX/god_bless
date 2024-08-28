package Spotify;

public class Player {
    private Object lock = new Object();
    private boolean isPlaying;

    public void play() {
        System.out.println("Музыка запущена");
        synchronized (lock) {
            isPlaying = true;
        }
    }

    public void pause() {
        System.out.println("Музыка на паузе");
        synchronized (lock) {
            isPlaying = false;
        }
    }

    public void skip() {
        System.out.println("Следующая композиция");
    }

    public void previous() {
        System.out.println("Предыдущая композиция");
    }
}
