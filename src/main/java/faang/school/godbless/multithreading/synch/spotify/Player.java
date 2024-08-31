package faang.school.godbless.multithreading.synch.spotify;

public class Player {

    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play() {
        synchronized (lock) {
            if (!isPlaying) {
                isPlaying = true;
                System.out.println("Играем");
            }
        }
    }

    public void pause() {
        synchronized (lock) {
            if (isPlaying) {
                isPlaying = false;
                System.out.println("Пауза");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            System.out.println("Пропускаем");
        }
    }

    public void previous() {
        synchronized (lock) {
            System.out.println("Предыдущая песня");
        }
    }
}
