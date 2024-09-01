package faang.school.godbless.Spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play, "Play Thread");
        Thread pauseThread = new Thread(player::pause, "Pause Thread");
        Thread skipThread = new Thread(player::skip, "Skip Thread");
        Thread previousThread = new Thread(player::previous, "Previous Thread");

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}