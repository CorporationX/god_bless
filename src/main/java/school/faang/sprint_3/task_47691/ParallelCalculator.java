package school.faang.sprint_3.task_47691;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
@Getter
public class ParallelCalculator implements Callable<Integer> {
    @NonNull
    private final List<Warrior> wariorsList;

    @Override
    public Integer call() {
        return wariorsList.stream()
                .mapToInt(Warrior::getPower)
                .sum();
    }
}
