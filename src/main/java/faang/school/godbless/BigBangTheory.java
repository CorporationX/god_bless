package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Task task1 = new Task("big", "bank");
        Task task2 = new Task("adsf","sera");
        Task task3 = new Task("beka","hadi");
        Task task4 = new Task("nurs","purs");
        List<Task> taskList = List.of(task1,task2,task3,task4);
        taskList.forEach(executor::submit);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(350, TimeUnit.MILLISECONDS)) {
                log.info("forced stop");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
                log.info("forced stop");
            executor.shutdownNow();
        }
        System.out.println("God Bless!");
    }
}