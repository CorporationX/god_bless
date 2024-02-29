package faang.school.godbless.spotify;

public class Player {
    private final Object LOCK = new Object();
    private Boolean isPlaying = true;


    public void play() {
        synchronized (LOCK) {
            this.isPlaying = true;
            System.out.println("Воспроизведение");
            System.out.println(isPlaying);
        }
    }

    public void pause() {
        synchronized (LOCK) {
            this.isPlaying = false;
            System.out.println("Пауза");
            System.out.println(isPlaying);
        }
    }

    public void skip() {
        synchronized (LOCK) {
            this.isPlaying = true;
            System.out.println("Воспроизведение следующей песни");
            System.out.println(isPlaying);
        }
    }

    public void previous() {
        synchronized (LOCK) {
            this.isPlaying = true;
            System.out.println("Воспроизведение предыдущей песни");
            System.out.println(isPlaying);
        }
    }
}
