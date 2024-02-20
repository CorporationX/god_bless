package faang.school.godbless.theywerenice2902;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    private static final String[] CHORES = {"Wash dishes", "Do the laundry", "To iron shirts", "Wash floors", "Cook a supper"};

    public static void main(String[] args) throws InterruptedException {
        ExecutorService homeRoutineExecutor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            homeRoutineExecutor.execute(new Chore(chore));
        }
        homeRoutineExecutor.shutdown();
        homeRoutineExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("Home routine is done:)");
    }
}
