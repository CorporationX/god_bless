package school.faang.sprint_3;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Army {
    private List<Hero> heroes;

    public int calculateTotalPower() throws InterruptedException {
        int threadsCount = 4;
        PowerThread[] threads = new PowerThread[threadsCount];
        int packageSize = heroes.size() / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            PowerThread thread = new PowerThread(heroes.subList(i, i + 1));
            threads[i] = thread;
            thread.start();
        }

        for (var thread : threads) {
            thread.join();
        }

        System.out.println(
                Arrays.stream(threads).map(thread -> thread.getPowerSum()).mapToInt(value -> value).sum()
        );

        return 0;
    }
}
