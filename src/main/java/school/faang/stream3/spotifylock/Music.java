package school.faang.stream3.spotifylock;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Thread> listeners = List.of(
                new Thread(() -> {
                    player.play();
                    player.skip();
                    player.skip();
                }),
                new Thread(() -> {
                    player.pause();
                    player.previous();
                    player.play();
                }),
                new Thread(() -> {
                    player.previous();
                    player.play();
                    player.previous();
                }),
                new Thread(() -> {
                    player.skip();
                    player.play();
                })
        );
        listeners.forEach(Thread::start);
    }
}
