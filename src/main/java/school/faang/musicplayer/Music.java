package school.faang.musicplayer;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Music {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        playThread.start();
        Thread pauseThread = new Thread(player::pause);
        pauseThread.start();
        Thread skipThread = new Thread(player::skip);
        skipThread.start();
        Thread previousThread = new Thread(player::previous);
        previousThread.start();


    }
}
