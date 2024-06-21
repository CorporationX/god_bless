package faang.school.godbless.bigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task taskOne = new Task("User 1","Wake up");
        Task taskTwo = new Task("User 2","Learn java");
        Task taskThree = new Task("User 1","Learn spring");
        Task taskFour = new Task("User 1","Learn algorithms");
        executorService.submit(taskOne);
        executorService.submit(taskTwo);
        executorService.submit(taskThree);
        executorService.submit(taskFour);
        executorService.shutdown();
        System.out.println("thread pool shot down");
    }
}
