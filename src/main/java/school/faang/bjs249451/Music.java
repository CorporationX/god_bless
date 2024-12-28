package school.faang.bjs249451;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Music {
    public static void main(String[] args) {

        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pouseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previusThread = new Thread(player::previous);

        log.info("Starting playThread");
        playThread.start();
        log.info("Starting pouseThread");
        pouseThread.start();
        log.info("Starting skipThread");
        skipThread.start();
        log.info("Starting previusThread");
        previusThread.start();

    }
}
