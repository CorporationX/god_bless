package school.faang.Mnogopotochka.ParallelismThread.BJS2_36377;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pig2Thread extends  PigThread{
    private static final Logger log = LoggerFactory.getLogger(Pig2Thread.class);
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        log.info("{} начал строить дом из {}",getPigName(), getMaterial());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.warn("Поток прерван", e);
        }
        log.info("{} закончил сторить дом из {}",getPigName(),getMaterial());
    }
}
