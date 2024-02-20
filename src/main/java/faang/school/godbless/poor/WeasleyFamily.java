package faang.school.godbless.poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash dishes", "Clean room", "Do laundry", "Mow lawn", "Cook dinner"};
        ExecutorService taskHandler = Executors.newCachedThreadPool();

        for (String chore : chores) {
            taskHandler.submit( new Chore( chore ) );
        }
        taskHandler.shutdown();
    }

}
