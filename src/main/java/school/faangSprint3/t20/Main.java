package school.faangSprint3.t20;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();

        String[] vladNames = {"vlad1", "vlad2", "vlad3"};
        for (String name : vladNames) {
            controller.addVlad(new TamagotchiVlad(name));
        }
        Runnable[] actions = {
                () -> {
                    for (int i = 0; i < 3; i++) {
                        controller.feedAll();
                        controller.playAll();
                    }
                },
                () -> {
                    for (int i = 0; i < 3; i++) {
                        controller.cleanAll();
                        controller.sleepAll();
                    }
                },
                () -> {
                    for (int i = 0; i < 3; i++) {
                        controller.playAll();
                        controller.feedAll();
                    }
                }
        };

        Thread[] threads = new Thread[actions.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(actions[i]);
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Симуляция завершена.");
    }
}