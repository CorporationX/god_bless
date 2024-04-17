package faang.school.godbless.SpotifyBlocking;

import java.util.Arrays;
import java.util.List;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player(getSongs());

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }

    private static List<String> getSongs() {
        return Arrays.asList("Lose Yourself - Eminem",
                "Juicy - The Notorious B.I.G.",
                "Stan - Eminem ft. Dido",
                "HUMBLE. - Kendrick Lamar",
                "Gangsta's Paradise - Coolio ft. L.V.");
    }
}
