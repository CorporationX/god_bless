package big_bang_theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task task1 = new Task("Sheldon", "Theory");
        Task task2 = new Task("Lonard", "Model");
        Task task3 = new Task("Govard", "Tools");
        Task task4 = new Task("RadjeshCutrapali", "Analyz");
            executor.submit(task1);
            executor.submit(task2);
            executor.submit(task3);
            executor.submit(task4);
            executor.shutdown();
            while (!executor.isTerminated()){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Complete");
    }
}