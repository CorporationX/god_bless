package school.faang.bjs2_73073;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private static List<Chore> chores = Arrays.asList(Chore.WASH_DISHES, Chore.SWEEP_FLOOR, Chore.COOK_DINNER);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.forEach(chore -> executorService.execute(new ChoreTask(chore)));
        executorService.shutdown();
    }
}
