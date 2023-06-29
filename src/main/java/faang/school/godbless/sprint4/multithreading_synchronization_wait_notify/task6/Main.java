package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task6;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TamagotchiVlad vlad1 = new TamagotchiVlad();
        TamagotchiVlad vlad2 = new TamagotchiVlad();
        TamagotchiVlad vlad3 = new TamagotchiVlad();
        TamagotchiVlad vlad4 = new TamagotchiVlad();
        TamagotchiVlad vlad5 = new TamagotchiVlad();

        VladController controller = new VladController();
        controller.addTamagotchi(vlad1);
        controller.addTamagotchi(vlad2);
        controller.addTamagotchi(vlad3);
        controller.addTamagotchi(vlad4);
        controller.addTamagotchi(vlad5);

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });
        Thread thread2 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();
        controller.deleteTamagotchi(vlad4);
        thread1.join();
        thread2.join();

        System.out.println("Done");
    }
}
