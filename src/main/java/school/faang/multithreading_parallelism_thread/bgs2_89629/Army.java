package school.faang.multithreading_parallelism_thread.bgs2_89629;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Collections.synchronizedList;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public void addSquad(@NonNull Squad squad) {
        squads.add(squad);
    }

    public Optional<Integer> calculateTotalPower() {
        List<Integer> synchronizedIntegerList = synchronizedList(new ArrayList<>());
        Function<Squad, Runnable> taskSumEnergiesFighters = (squad) ->
                () -> synchronizedIntegerList.add(squad.calculateSquadPower());

        List<Thread> squadThreads = squads.stream()
                .filter(Objects::nonNull)
                .map(taskSumEnergiesFighters)
                .map(Thread::new)
                .toList();

        squadThreads.stream()
                .peek(Thread::start)
                .toList()
                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        return synchronizedIntegerList.stream().reduce(Integer::sum);
    }
}