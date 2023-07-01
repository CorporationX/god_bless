package faang.school.godbless.tamagotchi.vlad;

public class Main {
    public static void main(String[] args) {
        TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad();
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad();
        TamagotchiVlad tamagotchiVlad3 = new TamagotchiVlad();
        TamagotchiVlad tamagotchiVlad4 = new TamagotchiVlad();

        VladController controller = new VladController();

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });

        thread1.start();
    }
}
