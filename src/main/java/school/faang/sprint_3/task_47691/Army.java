package school.faang.sprint_3.task_47691;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RequiredArgsConstructor
public class Army {
    @NonNull
    private final List<Warrior> warriors;
    private static final int AMOUNT_OF_THREADS = 5;

    public void addWarrior(@NonNull Warrior warrior) {
        warriors.add(warrior);
    }

    public int calculateTotalPower() throws InterruptedException {
        int currentPositionInList = 0;
        int oneThreadCalculationPart = (int) Math.ceil(warriors.size() / (double) AMOUNT_OF_THREADS);
        List<ParallelCalculator> parallelCalculators = new ArrayList<>();
        while (currentPositionInList < warriors.size()) {
            int startOfSublist = currentPositionInList;
            int endOfSublist = startOfSublist + oneThreadCalculationPart;

            List<Warrior> sublistToCalculate;
            try {
                sublistToCalculate = warriors.subList(startOfSublist,
                        endOfSublist);
            } catch (IndexOutOfBoundsException ignored) {
                sublistToCalculate = warriors.subList(startOfSublist, warriors.size() - 1);
            }
            currentPositionInList = endOfSublist;

            parallelCalculators.add(new ParallelCalculator(sublistToCalculate));
            
        }

        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);
        try {
            List<Future<Integer>> threadsResults = executorService.invokeAll(parallelCalculators);

            return threadsResults.stream()
                    .mapToInt(future -> {
                        try {
                            return future.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
        } finally {
            executorService.shutdown();
        }
    }
}
