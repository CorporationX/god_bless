package school.faang.multithreading_parallelism_thread.bjs2_91292;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1 = new Pig1Thread();
        Pig2Thread pig2 = new Pig2Thread();
        Pig3Thread pig3 = new Pig3Thread();

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Игра завершена.");
    }
}
