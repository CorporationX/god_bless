package school.faang.BJS2_35881;

import school.faang.BJS2_35881.characters.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Army {
    private static final int NUMBER_OF_TYPES = 3;
    private final List<Character> characters = new ArrayList<>();

    public void addUnit(Character character) {
        characters.add(character);
    }

    public int calculateTotalPower() {
        List<List<Character>> charactersByType = divideIntoTypes();
        AtomicInteger totalPower = new AtomicInteger();

        Thread[] threads = new Thread[NUMBER_OF_TYPES];

        for (int i = 0; i < NUMBER_OF_TYPES; i++) {
            final int index = i;

            threads[i] = new Thread(() -> {
                int sum = charactersByType.get(index).stream()
                        .mapToInt(Character::getPower)
                        .sum();
                totalPower.addAndGet(sum);
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        return totalPower.get();
    }

    public int calculateTotalPower2() {
        List<List<Character>> charactersByType = divideIntoTypes();
        AtomicInteger totalPower = new AtomicInteger();

        ExecutorService executorService = Executors.newFixedThreadPool(charactersByType.size());

        List<Future<Integer>> futures = charactersByType.stream()
                .map(typeCharacters -> executorService.submit(() ->
                        typeCharacters.stream()
                                .mapToInt(Character::getPower)
                                .sum()
                )).toList();

        for (Future<Integer> future : futures) {
            try {
                totalPower.addAndGet(future.get());
            } catch (InterruptedException | ExecutionException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

        executorService.shutdown();

        return totalPower.get();
    }

    private List<List<Character>> divideIntoTypes() {
        return characters.stream()
                .collect(Collectors.groupingBy(Character::getType))
                .values()
                .stream()
                .toList();
    }
}
