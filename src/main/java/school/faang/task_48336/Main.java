package school.faang.task_48336;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.faang.task_48336.WeasleyFamily.CHORES;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (var chore : CHORES) {
            service.submit(chore);
        }

        service.shutdown();
    }
}
