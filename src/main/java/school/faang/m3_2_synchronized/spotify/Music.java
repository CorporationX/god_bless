package school.faang.m3_2_synchronized.spotify;

public class Music {

    public static final int SLEEP_TIMEOUT = 1000;

    public static void main(String[] args) {
        Player player = new Player();
        Thread playMusic = new Thread(() -> {
            player.play();
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread pauseMusic = new Thread(() -> {
            player.pause();
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread skipMusic = new Thread(() -> {
            player.skip();
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        final Thread previousMusic = new Thread(() -> {
            player.previous();
            try {
                Thread.sleep(SLEEP_TIMEOUT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        playMusic.start();
        pauseMusic.start();
        skipMusic.start();
        previousMusic.start();
    }
}
