package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BluetoothPlayer {
    public void play(Boolean isPlaying){
        try {
            log.info("play requested " + isPlaying);
            Thread.sleep(1000);
            log.info("play finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void pause(Boolean isPlaying){
        try {
            log.info("pause requested " + isPlaying);
            Thread.sleep(1000);
            log.info("pause finised ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void skip(Boolean isPlaying){
        try {
            log.info("skip reqyested " + isPlaying);
            Thread.sleep(1000);
            log.info("skip finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void previous(Boolean isPlaying){
        try {
            log.info("previeous requested " + isPlaying);
            Thread.sleep(1000);
            log.info("previeous finished");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
