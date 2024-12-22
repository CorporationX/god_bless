package school.faang.bjs_48017;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Army {
    private final List<Character> characters = new ArrayList<>();

    public int calculateTotalPower() {
        List<CalculatePower> calculatePowers = characters.stream()
                .map(CalculatePower::new)
                .toList();

        List<Thread> threads = calculatePowers.stream()
                .map(Thread::new)
                .toList();

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Thread was interrupted", e);
            }
        });

        return calculatePowers.stream()
                .mapToInt(CalculatePower::getPower)
                .sum();
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }
}
