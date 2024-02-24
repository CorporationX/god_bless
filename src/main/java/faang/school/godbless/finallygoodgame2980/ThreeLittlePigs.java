package faang.school.godbless.finallygoodgame2980;

import faang.school.godbless.finallygoodgame2980.pigthreads.Pig1Thread;
import faang.school.godbless.finallygoodgame2980.pigthreads.Pig2Thread;
import faang.school.godbless.finallygoodgame2980.pigthreads.Pig3Thread;
import faang.school.godbless.finallygoodgame2980.pigthreads.PigThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<PigThread> threads = new ArrayList<>(List.of(
                new Pig1Thread("Nif-Nif", "Straw"),
                new Pig2Thread("Naf-Naf", "Stick"),
                new Pig3Thread("Nuf-Nuf", "Brick")
        ));
        for (PigThread thread : threads) {
            executor.execute(thread);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All houses are built. Here comes the wolf...");
    }
}
