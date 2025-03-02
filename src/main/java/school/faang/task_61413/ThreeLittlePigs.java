package school.faang.task_61413;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread nifNif = new Pig1Thread();
        Pig2Thread nufNuf = new Pig2Thread();
        Pig3Thread nafNaf = new Pig3Thread();

        nifNif.start();
        nufNuf.start();
        nafNaf.start();

        try {
            nifNif.join();
            nufNuf.join();
            nafNaf.join();
        } catch (InterruptedException e) {
            log.error("Wolf interrupted construction: ", e);
        }

        log.info("The game is over!");
    }
}
