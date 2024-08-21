package faang.school.godbless.cachedThreadPools;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("laundry", "mopping floors",
                "washing dishes", "changing sheets", "clean Kitchen",
                "cooking dinner", "making beds", "cleaning carpets");

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore choreToDo = new Chore(chore);
            executorService.execute(choreToDo);
        }

        executorService.shutdown();
    }
}
