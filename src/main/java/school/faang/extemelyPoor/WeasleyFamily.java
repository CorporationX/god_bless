package school.faang.extemelyPoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {new Chore("Study Java"), new Chore("Study JavaScript"), new Chore("Study Spring"), new Chore("Study React"), new Chore("Study Postgresql")};
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}
