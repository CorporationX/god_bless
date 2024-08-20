package faang.school.godbless.thirdsprint.spotify;

import java.util.List;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        List<String> playlist = List.of(
                "Bohemian Rhapsody by Queen",
                "Stairway to Heaven by Led Zeppelin",
                "Hotel California by Eagles",
                "Imagine by John Lennon",
                "Smells Like Teen Spirit by Nirvana"
        );

        Player player = new Player(playlist);

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
