package faang.school.godbless.Spotify_Cancelling;

import java.util.ArrayList;
import java.util.List;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        List<String> songs = new ArrayList<>();
        Player myPlayer = new Player(songs);
        myPlayer.queueAdd("My protection");
        myPlayer.queueAdd("On sunrise");
        myPlayer.queueAdd("Bakamitai");
        myPlayer.queueAdd("Judgement");
        myPlayer.queueAdd("The man who sold the world");
        Thread playThread = new Thread(() -> myPlayer.play());
        Thread pauseThread = new Thread(() -> myPlayer.pause());
        Thread previousThread = new Thread(() -> myPlayer.previous());
        Thread skipThread = new Thread(() -> myPlayer.skip());
        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
