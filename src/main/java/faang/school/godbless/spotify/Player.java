package faang.school.godbless.spotify;

public class Player {
    private Boolean isPlaying = true;
    private final Object lock = new Object();

    public void play() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Воспроизведение");
            System.out.println(isPlaying);
        }
    }

    public void pause() {
        synchronized (lock) {
            this.isPlaying = false;
            System.out.println("Пауза");
            System.out.println(isPlaying);
        }
    }

    public void skip() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Воспроизведение следующей песни");
            System.out.println(isPlaying);
        }
    }

    public void previous() {
        synchronized (lock) {
            this.isPlaying = true;
            System.out.println("Воспроизведение предыдущей песни");
            System.out.println(isPlaying);
        }
    }
}
