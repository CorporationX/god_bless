package faang.school.godbless.Spotify;

public class Player {

    private Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println(Thread.currentThread().getName() + " Включил музыку");
    }

    public void pause() {
        synchronized (lock) {
            isPlaying = false;
        }
        System.out.println(Thread.currentThread().getName() + " Поставил паузу");
    }

    public void skip() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println(Thread.currentThread().getName() + " Пропустил трек");
    }

    public void previous() {
        synchronized (lock) {
            isPlaying = true;
        }
        System.out.println(Thread.currentThread().getName() + " Включил предыдущий трек");
    }
}
