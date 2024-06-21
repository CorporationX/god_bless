package faang.school.godbless.task33;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task task1= new Task("1","1");
        Task task2= new Task("2","2");
        Task task3= new Task("3","3");
        Task task4= new Task("4","4");
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);
        executorService.shutdown();
    }
}
