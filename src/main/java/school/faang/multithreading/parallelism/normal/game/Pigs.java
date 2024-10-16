package school.faang.multithreading.parallelism.normal.game;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class Pigs {
    public static void main(String[] args) throws InterruptedException {
        PigThread pig1Thread = new Pig1Thread("Ниф-Ниф", Material.STRAW);
        PigThread pig2Thread = new Pig2Thread("Нуф-Нуф", Material.STICK);
        PigThread pig3Thread = new Pig3Thread("Наф-Наф", Material.BRICK);
        List<PigThread> pigs = Arrays.asList(pig1Thread, pig2Thread, pig3Thread);

        pigs.forEach(Thread::start);
        for (PigThread pig : pigs) {
            pig.join();
        }

        log.info("Игра завершена!");
    }
}
