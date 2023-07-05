package faang.school.godbless.Multitrading2.SkyNet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SkyNet {
    public static void main(String[] args) {
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            robots.add(new Robot("Sara"));
        }

        ExecutorService service = Executors.newFixedThreadPool(100);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            service.execute(robots.get(i)::attack);
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis() - time);
        System.out.println(Robot.getCountMurders());
    }
}
