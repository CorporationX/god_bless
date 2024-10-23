package school.faang.Mnogopotochka.Synhronaized.BJS2_36712;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public class TamagotchiVlad {
    private static final Logger log = LoggerFactory.getLogger(TamagotchiVlad.class);
    private final Object lock = new Object();
    private String name;

    public synchronized void feed(){
        log.info("{} eat", getName());
        log.info("{} tookOver", getName());
    }

    public synchronized void play(){
        log.info("{} play", getName());
        log.info("{} played", getName());
    }

    public synchronized void clean(){
        log.info("{} clean", getName());
        log.info("{} haveAWash", getName());
    }

    public synchronized void sleep(){
        log.info("{} sleep", getName());
        log.info("{} getSomeSleep", getName());
    }
}
