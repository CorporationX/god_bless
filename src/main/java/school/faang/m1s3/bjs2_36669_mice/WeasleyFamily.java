package school.faang.m1s3.bjs2_36669_mice;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static String[] chores = new String[]{"Wash dishes", "Sweep floor", "Cook dinner"};

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Arrays.stream(chores).forEach(chore -> {
            Chore newChore = new Chore(chore);
            service.submit(newChore);
        });

        service.shutdown();

        try {
            if(service.awaitTermination(5, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
