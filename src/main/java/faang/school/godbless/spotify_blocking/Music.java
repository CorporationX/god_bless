package faang.school.godbless.spotify_blocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> {
            try {
                player.play(player.getPlayList().get(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread pauseThread = new Thread(() -> {
            try {
                player.pause(player.getPlayList().get(0));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread skipThread = new Thread(() -> {
            try {
                player.skip(player.getPlayList().get(3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread previousThread = new Thread(() -> {
            try {
                player.previous(player.getPlayList().get(4));
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
