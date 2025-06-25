package school.faang.bjs2_81888;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<String> tracks = List.of("Song 1", "Song 2", "Song 3");
        Player player = new Player(tracks);

        Thread playThread = new Thread(() -> {
            player.play();
        });

        Thread pauseThread = new Thread(() -> {
            player.pause();
        });
        Thread skipThread = new Thread(() -> {
            player.skip();
        });
        Thread previous = new Thread(() -> {
            player.previous();
        });

        playThread.start();
        pauseThread.start();
        skipThread.start();
    }
}
