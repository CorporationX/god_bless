package school.faang.task48208;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.faang.task48208.HouseholdChores.*;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<HouseholdChores> chores = new ArrayList<>(
                List.of(FLOOR, FOOD, TABLEWARE)
        );

        ExecutorService executorService = Executors.newCachedThreadPool();

        chores.forEach(chore -> executorService.submit(new Chore(chore)));

        executorService.shutdown();
    }
}
