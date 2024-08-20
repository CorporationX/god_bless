package faang.school.godbless.bigBangTheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(4)) {
            Task taskOne = new Task("Sheldon", "task one");
            Task taskTwo = new Task("Leo", "task two");
            Task taskThree = new Task("Goward", "task three");
            Task taskFour = new Task("Radj", "task four");

            executorService.execute(taskOne);
            executorService.execute(taskTwo);
            executorService.execute(taskThree);
            executorService.execute(taskFour);

            executorService.shutdownNow();
        }
    }
}
