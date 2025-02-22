package spotify;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        List<String> playlist = List.of(
                "Brandy Kills - Space Police",
                "Editors - Sugar",
                "New Order - Crystal",
                "Brand New - At the Bottom",
                "Kill Shelter - Bodies"
        );

        Player player = new Player(playlist);

        final Thread thread1 = new Thread(() -> player.play());
        final Thread thread2 = new Thread(() -> player.pause());
        final Thread thread3 = new Thread(() -> player.previous());
        final Thread thread4 = new Thread(() -> player.skip());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
