package faang.school.godbless.spotify_blocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> {
            try {
                player.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread pauseThread = new Thread(() -> {
            try {
                player.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread skipThread = new Thread(() -> {
            try {
                player.skip();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread previousThread = new Thread(() -> {
            try {
                player.previous();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
