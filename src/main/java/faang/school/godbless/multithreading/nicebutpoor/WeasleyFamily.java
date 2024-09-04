package faang.school.godbless.multithreading.nicebutpoor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = {
                "wash dishes",
                "clean house",
                "cook food",
                "do laundry"};

        ExecutorService executor = Executors.newCachedThreadPool();

        Arrays.stream(chores).forEach(chore -> executor.execute(new Chore(chore)));

        executor.shutdown();
    }

}
