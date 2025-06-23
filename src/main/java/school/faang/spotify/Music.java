package school.faang.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(false);
        Thread playMusicThread = new Thread(player::play);
        playMusicThread.start();

        Thread pauseMusicThread = new Thread(player::pause);
        pauseMusicThread.start();

        Thread previousMusicThread = new Thread(player::previous);
        previousMusicThread.start();

        Thread skipMusicThread = new Thread(player::skip);
        skipMusicThread.start();


    }
}
