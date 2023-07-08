package faang.school.godbless.tamagotchi;

public class Main {
    public static void main(String[] args) {
        TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad("Sleepy");
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad("Happy");
        TamagotchiVlad tamagotchiVlad3 = new TamagotchiVlad("Big");
        VladController controller = new VladController();
        controller.addTamagotchi(tamagotchiVlad1);
        controller.addTamagotchi(tamagotchiVlad2);
        controller.addTamagotchi(tamagotchiVlad3);
        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.deleteTamagotchi(tamagotchiVlad1);
            controller.cleanAll();
            controller.sleepAll();
            controller.playAll();
        });

        Thread thread2 = new Thread(() -> {
            controller.playAll();
            controller.sleepAll();
            controller.playAll();
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("наигрались");
    }
}

