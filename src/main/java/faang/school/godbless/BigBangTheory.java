package faang.school.godbless;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Task("Sheldon","theory"));
        executorService.execute(new Task("Leonard","model"));
        executorService.execute(new Task("Govard","create tools"));
        executorService.execute(new Task("Radgesh","data analysis"));
        executorService.shutdown();
    }
}
