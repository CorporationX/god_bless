package faang.school.godbless.BJS2_24381;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousTrack = new Thread(player::previous);

        playThread.start();
        skipThread.start();
        previousTrack.start();
        pauseThread.start();
    }
}
