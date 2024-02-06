package faang.school.godbless.alexbulgakoff.multithreading.parallelism.distributedarmy;

import faang.school.godbless.alexbulgakoff.multithreading.parallelism.distributedarmy.character.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        ExecutorService executor = Executors.newFixedThreadPool(characters.size());


        for (int i = 0; i < characters.size(); i++) {
            executor.execute(() -> {
                synchronized (this) {
                    savedPower.set(characters.stream()
                            .mapToInt(Character::getPower)
                            .sum());
                }
            });
            executor.shutdown();
        }

        return savedPower.get();
    }
}
