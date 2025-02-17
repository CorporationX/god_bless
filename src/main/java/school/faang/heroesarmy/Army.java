package school.faang.heroesarmy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class Army {
    private final List<Squad> squads = new ArrayList<>();

    public int calculateTotalPower(List<Squad> squads) throws InterruptedException {
        List<Integer> results = Collections.synchronizedList(new ArrayList<>());
        // без syncronizedList итог всегда выходил разный, то 55, то 90
        List<Thread> threads = new ArrayList<>();

        for (Squad squad : squads) {
            Thread thread = new Thread(() -> results.add(squad.calculateSquadPower()));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        return results.stream().reduce(0, (num1, num2) -> num1 + num2);
    }
}
