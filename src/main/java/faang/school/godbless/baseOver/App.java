package faang.school.godbless.baseOver;

import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        MilitaryBase base1 = new MilitaryBase();
        MilitaryBase base2 = new MilitaryBase();

        executor.execute(base1);
        executor.execute(base2);

        base1.sendMessage("Attack at dawn!", base2);
        base2.sendMessage("Roger that!", base1);

        base1.stop();
        base2.stop();

        executor.shutdown();

        boolean terminated = false;
        try {
            terminated = executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (terminated) {
            System.out.println("All threads have been closed");
        } else {
            System.out.println("Not all threads have been closed");
        }
    }

}
