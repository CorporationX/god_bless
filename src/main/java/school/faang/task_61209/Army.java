package school.faang.task_61209;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class Army {
    @NonNull
    private final List<Squad> squads;

    public int calculateTotalPower() throws ThreadCompletionWaitingException {
        List<Thread> threads = new ArrayList<>();
        List<Integer> totalPower = Collections.synchronizedList(new ArrayList<>());

        squads.forEach(squad -> {
            Thread thread = new Thread(() -> totalPower.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        });

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new ThreadCompletionWaitingException(e.getMessage());
            }
        }

        return totalPower.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
