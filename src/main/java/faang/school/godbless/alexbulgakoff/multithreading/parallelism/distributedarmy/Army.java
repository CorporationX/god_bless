package faang.school.godbless.alexbulgakoff.multithreading.parallelism.distributedarmy;

import faang.school.godbless.alexbulgakoff.multithreading.parallelism.distributedarmy.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alexander Bulgakov
 */

public class Army {
    List<Character> characters = new ArrayList<>();

    public void addUnit(Character character){
        characters.add(character);
    }

    public long calculateTotalPower() {
        AtomicInteger savedPower = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();


        for (int i = 0; i < characters.size(); i++) {
            Thread thread = new Thread(() -> {
                synchronized (this) {
                    savedPower.set(characters.stream()
                            .mapToInt(Character::getPower)
                            .sum());
                }
            });
            threads.add(thread);
            thread.start();
        }

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return savedPower.get();
    }
}
