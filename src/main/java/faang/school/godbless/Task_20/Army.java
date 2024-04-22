package faang.school.godbless.Task_20;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class Army {
    static final List<Subdivisions> SUBDIVISIONS = new ArrayList<>();
    Integer result = 0;

    int calculateTotalPower() {
        ExecutorService executorService = Executors.newFixedThreadPool(SUBDIVISIONS.size());
        for (Subdivisions subdivision : SUBDIVISIONS) {
            executorService.submit(() -> result += subdivision.getPower());
        }
        executorService.shutdown();
        return result;
    }

    void addUnit(Subdivisions subdivision) {
        SUBDIVISIONS.add(subdivision);
    }
}
