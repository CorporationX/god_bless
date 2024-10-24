package school.faangSprint3.t20;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Влад-1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Влад-2");
        TamagotchiVlad vlad3 = new TamagotchiVlad("Влад-3");

        controller.addVlad(vlad1);
        controller.addVlad(vlad2);
        controller.addVlad(vlad3);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                controller.feedAll();
                controller.playAll();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                controller.cleanAll();
                controller.sleepAll();
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                controller.playAll();
                controller.feedAll();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Симуляция завершена.");
    }
}