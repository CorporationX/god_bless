package Spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread play = new Thread(player::play);
        play.start();
        Thread pause = new Thread(player::pause);
        pause.start();
        Thread skip = new Thread(player::skip);
        skip.start();
        Thread previous = new Thread(player::previous);
        previous.start();
    }
}
