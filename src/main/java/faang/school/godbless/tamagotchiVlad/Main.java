package faang.school.godbless.tamagotchiVlad;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad vlad1 = new TamagotchiVlad("Vlad1");
        TamagotchiVlad vlad2 = new TamagotchiVlad("Vlad2");

        controller.addTamagotchi(vlad1);
        controller.addTamagotchi(vlad2);

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        Thread thread2 = new Thread(() -> {
            controller.playAll();
            controller.playAll();
        });

        thread1.start();
        thread2.start();
    }
}
