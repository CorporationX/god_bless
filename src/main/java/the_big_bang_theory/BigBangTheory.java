package the_big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Task sheldonTask = new Task("Sheldon", "Theory Preparation");
        Task leonardTask = new Task("Leonard", "Experiment Simulation");
        Task howardTask = new Task("Howard", "Tool Development");
        Task rajeshTask = new Task("Rajesh", "Data Analysis");

        executorService.execute(sheldonTask);
        executorService.execute(leonardTask);
        executorService.execute(howardTask);
        executorService.execute(rajeshTask);
        executorService.shutdown();
        if (executorService.awaitTermination(3, TimeUnit.SECONDS)) {
            System.out.println("Все задачи выполнены успешно");
        }else {
            System.out.println("Превышено время выполнения задач");
        }



    }
}
