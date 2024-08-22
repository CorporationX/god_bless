package faang.school.godbless.hsam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Army {
    private final List<Unit> units = new ArrayList<>();

    public int calculatePower() {
        int countThreads = (int) units.stream()
                .distinct()
                .count();

        ExecutorService poolThreads = Executors.newFixedThreadPool(countThreads);

        int totalPower = 0;


        List<PowerThread> powerThreads = new ArrayList<>();
        for (int i = 0; i < countThreads; i++) {

        }
    }
}
