package spotify.blocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playMusic = new Thread(player::play);
        Thread pauseMusic = new Thread(player::pause);
        Thread skipMusic = new Thread(player::skip);
        Thread previousMusic = new Thread(player::previous);

        playMusic.start();
        pauseMusic.start();
        skipMusic.start();
        previousMusic.start();
    }
}
