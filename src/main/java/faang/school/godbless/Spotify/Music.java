package faang.school.godbless.Spotify;

public class Music {
    public static void main(String... args) {

        Player player = new Player(new Object());

        Thread playThread = new Thread(()->{
            try {
                player.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
