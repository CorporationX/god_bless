package school.faang.Mnogopotochka.Synhronaized.BJS2_37164;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Player {
    private static final Logger log = LoggerFactory.getLogger(Player.class);
    private final Object lock = new Object();
    private boolean isPlaying = false;

    public void play(){
        synchronized (lock){
            if(!isPlaying){
                isPlaying = true;
                log.info("начать воспроизведение музыки");
            } else {
                log.info("музыка уже играет");
            }
        }
    }

    public void pause(){
        synchronized (lock){
            if(!isPlaying){
                isPlaying = false;
                log.info("поставить на паузу");
            } else {
                log.info("Музыка уже на паузе");
            }
        }
    }

    public void skip() {
        synchronized (lock) {
            log.info("пропустить трек");
        }
    }

    public void previous() {
        synchronized (lock) {
            log.info("вернуться к предыдущему треку");
        }
    }
}
