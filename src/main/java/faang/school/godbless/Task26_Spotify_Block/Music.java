package faang.school.godbless.Task26_Spotify_Block;

public class Music {
    public static void main(String[] args) {

        Player listener = new Player();
        Thread playThread = new Thread(() -> {
            listener.play(new Track("Prophecy"));
        });
        Thread pauseThread = new Thread(listener::pause);
        Thread addingTrackThread = new Thread(() -> {
            Player.addTrack(new Track("Taming Lions"));
        });
        Thread skipThread = new Thread(listener::skip);
        Thread prevTrackThread = new Thread(listener::previous);

        playThread.start();
        pauseThread.start();
        addingTrackThread.start();
        skipThread.start();
        prevTrackThread.start();

    }
}
