package faang.school.godbless.spotifyblock2970;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        ExecutorService playerExecutor = Executors.newFixedThreadPool(4);
        Player myPlayer = new Player();
        playerExecutor.execute(myPlayer::play);
        playerExecutor.execute(myPlayer::skip);
        playerExecutor.execute(myPlayer::pause);
        playerExecutor.execute(myPlayer::previous);
        playerExecutor.shutdown();
    }
}
