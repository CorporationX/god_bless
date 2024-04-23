package faang.school.godbless.tamagochi;

public class Main {
    public static void main(String[] args) {
        VladController vladController = new VladController();
        TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad();
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad();
        vladController.addTamagochi(tamagotchiVlad1);
        vladController.addTamagochi(tamagotchiVlad2);
        Thread thread1 = new Thread(() -> {
            Thread.currentThread().setName("User_1");
            vladController.feedAll();
            vladController.wakeUpAll();
            vladController.cleanAll();
            vladController.sleepAll();
            vladController.playAll();
        });
        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("User_2");
            vladController.wakeUpAll();
            vladController.feedAll();
            vladController.playAll();
            vladController.sleepAll();
            vladController.cleanAll();
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
