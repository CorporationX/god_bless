package school.faangSprint3.t20;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            initializeController();
            runSimulation();
            System.out.println("Симуляция завершена.");
        } catch (InterruptedException e) {
            System.err.println("Симуляция была прервана: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println("Произошла ошибка во время симуляции: " + e.getMessage());
        }
    }

    private static VladController controller;
    private static final List<Runnable> VLAD_ACTIONS = Arrays.asList(
            Main::feedAndPlay,
            Main::cleanAndSleep,
            Main::playAndFeed
    );

    private static void initializeController() {
        controller = new VladController();
        String[] vladNames = {"vlad1", "vlad2", "vlad3"};
        for (String name : vladNames) {
            controller.addVlad(new TamagotchiVlad(name));
        }
    }

    private static void feedAndPlay() {
        try {
            controller.feedAll();
            controller.playAll();
        } catch (Exception e) {
            System.err.println("Ошибка при кормлении и игре: " + e.getMessage());
        }
    }

    private static void cleanAndSleep() {
        try {
            controller.cleanAll();
            controller.sleepAll();
        } catch (Exception e) {
            System.err.println("Ошибка при уборке и сне: " + e.getMessage());
        }
    }

    private static void playAndFeed() {
        try {
            controller.playAll();
            controller.feedAll();
        } catch (Exception e) {
            System.err.println("Ошибка при игре и кормлении: " + e.getMessage());
        }
    }

    private static void runSimulation() throws InterruptedException {
        Thread[] threads = VLAD_ACTIONS.stream()
                .map(action -> new Thread(() -> {
                    try {
                        for (int i = 0; i < 3; i++) {
                            action.run();
                        }
                    } catch (Exception e) {
                        System.err.println("Ошибка в потоке: " + e.getMessage());
                    }
                }))
                .toArray(Thread[]::new);

        Arrays.stream(threads).forEach(Thread::start);

        for (Thread thread : threads) {
            thread.join();
        }
    }
}