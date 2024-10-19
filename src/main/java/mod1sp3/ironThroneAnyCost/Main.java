package mod1sp3.ironThroneAnyCost;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_AMOUNT = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        House houseStark = new House("Stark House", new ArrayList<>(List.of("Lord", "Wizard", "Knight")));
        User firstUser = new User("Eddard Stark");
        User secondUser = new User("Catelyn Stark");
        User thirdUser = new User("Robb Stark");
        User fourthUser = new User("Sansa Stark");

        executorService.submit(() ->  firstUser.joinHouse(houseStark, "Lord"));
        executorService.submit(() -> secondUser.joinHouse(houseStark, "Wizard"));
        executorService.submit(() ->  thirdUser.joinHouse(houseStark, "Knight"));
        executorService.submit(() -> fourthUser.joinHouse(houseStark, "Lord"));
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Sleep method error " + e.getMessage(), e);
        }
        firstUser.leaveHouse();

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Await termination error : " + e.getMessage(), e);
        }
    }
}
