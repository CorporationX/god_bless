package school.faang.Mnogopotochka.ParallelismThread.BJS2_36377;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ThreeLittlePigs {
    private static final Logger log = LoggerFactory.getLogger(ThreeLittlePigs.class);
    private static List<PigThread> pigs = new ArrayList<>();

    public static void main(String[] args) {
        addPig(new Pig1Thread("Nif Nif", "Straw"));
        addPig(new Pig2Thread("Nuf Nuf", "Stick"));
        addPig(new Pig3Thread("Naf Naf", "Brick"));

        pigs.forEach(Thread::start);

        for (PigThread pig : pigs) {
            try {
                pig.join();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }
        }
        log.info("Nгра завершена");
    }

    private static void addPig(PigThread pig){
        pigs.add(pig);
    }
}
