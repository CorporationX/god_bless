package faang.school.godbless.TheBigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Task("Sheldon","Prepare theory"));
        service.execute(new Task("Leonard","Modeling"));
        service.execute(new Task("Govard","Instruments developing"));
        service.execute(new Task("Radsh","Data analyse"));
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Program is ended");
    }
}
