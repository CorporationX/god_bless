package faang.school.godbless.BJS2_12442;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args){
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Task Sheldon = new Task("Sheldon" , "is solving a physical problem");
    Task Leonard = new Task("Leonard" , "is exploring a new territory");
    Task Penny = new Task("Penny" , "is performing experiment");
    Task Howard = new Task("Howard" , "development of a new device");

    executorService.submit(Sheldon);
    executorService.submit(Leonard);
    executorService.submit(Penny);
    executorService.submit(Howard);
    executorService.shutdown();
    }
}
