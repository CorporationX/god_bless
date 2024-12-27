package school.faang.task_49337;

public class Music {
    public static void main(String[] args) {
        Thread playMusic = new Thread(() -> Player.play());
        playMusic.start();

        Thread pauseMusic = new Thread(() -> Player.pause());
        pauseMusic.start();

        Thread skipMusic = new Thread(() -> Player.skip());
        skipMusic.start();

        Thread previousMusic = new Thread(() -> Player.previous());
        previousMusic.start();
    }
}
