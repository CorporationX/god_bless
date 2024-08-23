package faang.school.godbless.task.multithreading.tamagotchi.vlad;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_DEFAULT_VLADS = 10;
    private static final int THREAD_POOL_SIZE = 16;
    private static final int NEW_VLAD_INDEX = 12;
    private static final int SLEEP_MILL = 3000;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final VladController vladController = new VladController();
    private static final Random random = new Random();

    public static void main(String[] args) {
        var vlads = addDefaultVlads();
        var threads = getThreads(vlads);
        threads.forEach(executor::execute);
        executor.shutdown();
        threadSleep();
        printRageOfLists(vlads);
    }

    private static List<Thread> getThreads(List<TamagotchiVlad> vlads) {
        return List.of(
                new Thread(() -> vladController.addVlad(new TamagotchiVlad(NEW_VLAD_INDEX, "New vlad"))),
                new Thread(vladController::feedAll),
                new Thread(vladController::playAll),
                new Thread(() -> vladController.removeVlad(vlads.get(random.nextInt(9)))),
                new Thread(vladController::cleanAll),
                new Thread(() -> vladController.removeVlad(vlads.get(random.nextInt(9)))),
                new Thread(vladController::sleepAll)
        );
    }

    private static void printRageOfLists(List<TamagotchiVlad> vlads) {
        System.out.println("Vlad's from main:");
        vlads.forEach(System.out::println);
        System.out.println("Vlad's rom controller:");
        vladController.printAllVlads();
    }

    private static List<TamagotchiVlad> addDefaultVlads() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_DEFAULT_VLADS)
                .mapToObj(i -> new TamagotchiVlad(i, "Vlad " + i))
                .peek(vladController::addVlad)
                .toList();
    }

    private static void threadSleep() {
        try {
            Thread.sleep(SLEEP_MILL);
        } catch (InterruptedException e) {
            log.info("Error sleep: {}", e.getMessage());
        }
    }
}
