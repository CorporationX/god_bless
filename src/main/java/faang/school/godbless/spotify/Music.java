package faang.school.godbless.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Song toccata = new Song("Toccata & Fugue in D Minor", "J.S. Bach");
        Song fantasia = new Song("Fantasie Improptu", "F. Chopin");
        Song winter = new Song("Winter", "A. Vivaldi");

        Player player = new Player();
        player.setSong(fantasia);

        fantasia.setNext(winter);
        fantasia.setPrevious(toccata);

        toccata.setNext(fantasia);
        winter.setPrevious(fantasia);

        executor.execute(player::play);
        executor.execute(player::pause);
        executor.execute(player::skip);
        executor.execute(player::previous);
        executor.execute(player::previous);

        executor.shutdown();
    }
}
