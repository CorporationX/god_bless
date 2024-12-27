package school.faang.bjs247660;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreeLittlePigs {
    public static void main(String[] args) {
        List<PigThread> littlePigs = new ArrayList<>();
        littlePigs.add(new Pig1Thread("Nif-Nif", "straw and clay"));
        littlePigs.add(new Pig2Thread("Naf-Naf", "sticks"));
        littlePigs.add(new Pig3Thread("Nuf-Nuf", "bricks"));

        for (PigThread pigThread : littlePigs) {
            pigThread.start();
        }

        try {
            for (PigThread pigThread : littlePigs) {
                pigThread.join();
            }
            log.info("The game over");
        } catch (InterruptedException e) {
            log.error("The thread was interrupted {}", e.getMessage());
        }
    }
}