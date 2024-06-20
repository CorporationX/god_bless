package faang.school.godbless.module1.sprint3.task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = new Chore[5];
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < chores.length; i++) {
            service.execute(new Chore("Do something " + i));
        }
        service.shutdown();
        System.out.println("Pools done");

    }
}
