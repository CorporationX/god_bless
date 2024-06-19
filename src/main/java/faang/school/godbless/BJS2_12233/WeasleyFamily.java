package faang.school.godbless.BJS2_12233;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = new Chore[]{new Chore("wash the dishes"), new Chore("mow the lawn"), new Chore("clean the room"), new Chore("cook lunch")};
        ExecutorService service = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            service.submit(chore);
        }
        service.shutdown();
        try {
            service.awaitTermination(30, TimeUnit.SECONDS);
            System.out.println("All chores accomplished");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}
