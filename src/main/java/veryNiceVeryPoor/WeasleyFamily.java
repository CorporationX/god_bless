package veryNiceVeryPoor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"chore1", "chore2", "chore3", "chore4", "chore5", "chore6"};
        ExecutorService executorSerive = Executors.newCachedThreadPool();
        Arrays.stream(chores).forEach(chore -> executorSerive.execute(new Chore(chore)));
        executorSerive.shutdown();
    }
}
