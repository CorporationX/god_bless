package bjs2_90135;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Влад-1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Влад-2");

        controller.addVlad(vlad1);
        controller.addVlad(vlad2);

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        Thread thread2 = new Thread(() -> {
            controller.playAll();
            controller.cleanAll();
            controller.playAll();
            controller.cleanAll();
            controller.removeVlad(vlad1);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println("Финиш симуляции");
    }
}