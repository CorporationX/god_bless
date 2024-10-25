package school.faang.BJS2_36901;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {" clean dishes", "Clean floor", "cook diner", "fix boots", "clean dust"};

        ExecutorService pool = Executors.newCachedThreadPool();

        for(String chore : chores){
            pool.submit(new Chore(chore));
        }
        pool.shutdown();
        try{
            if(!pool.awaitTermination(5, TimeUnit.SECONDS)){
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }
        System.out.println("All task complete . ");
    }
}
