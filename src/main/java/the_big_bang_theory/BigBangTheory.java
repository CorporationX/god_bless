package the_big_bang_theory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        List<Task> tasks = List.of(new Task("Sheldon","preparation of the theory"),
                                    new Task("Leonard", "simulation of the experiment"),
                                    new Task("Howard","development of tools"),
                                    new Task("Rajesh","data analysis"));
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (var task:tasks) {
            executor.submit(task);
        }
        executor.shutdown();
        try{
            if(executor.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("The project is ready");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
