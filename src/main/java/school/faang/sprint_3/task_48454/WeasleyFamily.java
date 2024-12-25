package school.faang.sprint_3.task_48454;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {

        Chore[] chores = {
                new Chore("Играть на кожаной флейте"),
                new Chore("Приготовить хавчик"),
                new Chore("Душить удава")
        };

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executor.execute(chore);
        }
        executor.shutdown();
    }

}
