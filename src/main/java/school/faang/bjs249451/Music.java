package school.faang.bjs249451;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread playThread = new Thread(player::play);
        log.info("Starting playThread");
        playThread.start();

        Thread pouseThread = new Thread(player::pause);
        log.info("Starting pouseThread");
        pouseThread.start();

        Thread skipThread = new Thread(player::skip);
        log.info("Starting skipThread");
        skipThread.start();

        Thread previusThread = new Thread(player::previous);
        log.info("Starting previusThread");
        previusThread.start();

    }
}
