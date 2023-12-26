package TheBigBangTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Task> listOfTasks = new ArrayList<>();

        listOfTasks.add(new Task("Preparing theory"));
        listOfTasks.add(new Task("Modeling experiment"));
        listOfTasks.add(new Task("Tool developing"));
        listOfTasks.add(new Task("Data analisys"));

        for (Task task : listOfTasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        if (executorService.isTerminated()) {
            System.out.println("Все задачи выполнены");
        }
    }


}

