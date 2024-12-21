package school.faang.sprint_3.task_48201;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

@Getter
public class Army {
    private final List<Character> heroes = new ArrayList<>();

    public void addCharacter(Character character) {
        heroes.add(character);
    }

    public int calculateTotalPower() throws InterruptedException {
        AtomicInteger totalpower = new AtomicInteger(0);
        List<Thread> threadsArmy = new ArrayList<>();

        IntStream.range(0, heroes.size()).forEach(i -> {
            Thread thread = new Thread(() -> {
                totalpower.addAndGet(heroes.get(i).getPower());
            });
            threadsArmy.add(thread);
            thread.start();
        });

        for (Thread thread : threadsArmy) {
            thread.join();
        }

        return totalpower.get();
    }
}
