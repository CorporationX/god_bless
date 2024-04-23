package faang.school.godbless.Task_21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Task("Sheldon", "Theory preparing"));
        executorService.execute(new Task("Lonard", "Experiment modelling"));
        executorService.execute(new Task("Howard", "Tools development"));
        executorService.execute(new Task("Radjesh", "Data analysing"));
        executorService.shutdown();
    }
}
