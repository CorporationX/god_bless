package faang.school.godbless.spotify;

public class Player {
    private final Object LOCK = new Object();
    private Boolean isPlaying = false;


    public void play() {
        synchronized (LOCK) {
            if (!isPlaying) {
                this.isPlaying = true;
            }
            System.out.println("Воспроизведение");
            System.out.println(isPlaying);
        }
    }

    public void pause() {
        synchronized (LOCK) {
            if (isPlaying) {
                this.isPlaying = false;
            }
            System.out.println("Пауза");
            System.out.println(isPlaying);
        }
    }

    public void skip() {
        synchronized (LOCK) {
            if (!isPlaying) {
                this.isPlaying = true;
            }
            System.out.println("Воспроизведение следующей песни");
            System.out.println(isPlaying);
        }
    }

    public void previous() {
        synchronized (LOCK) {
            if (!isPlaying) {
                this.isPlaying = true;
            }
            System.out.println("Воспроизведение предыдущей песни");
            System.out.println(isPlaying);
        }
    }
}
