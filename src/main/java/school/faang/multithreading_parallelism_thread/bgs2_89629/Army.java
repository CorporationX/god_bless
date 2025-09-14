package school.faang.multithreading_parallelism_thread.bgs2_89629;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Function;

public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public Army() {
    }

    public void addSquad(@NonNull Squad squad) {
        squads.add(squad);
    }

    public Optional<Integer> calculateTotalPower() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(squads.size());
        Function<Squad, Runnable> taskSumEnergiesFighters = (squad) ->
             () -> queue.add(squad.calculateSquadPower());

        squads.stream()
                .filter(Objects::nonNull)
                .map(itemSquad -> new Thread(taskSumEnergiesFighters.apply(itemSquad)))
                .peek(Thread::start)
                .toList()
                .forEach(t -> {
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        return queue.stream().reduce(Integer::sum);
    }
}