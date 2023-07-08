package faang.school.godbless.sprint_3.multithreading.tamagochi_vlad;


public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController();
        Thread first = new Thread(() -> {
            controller.addVlad(new TamagotchiVlad(1));
            controller.addVlad(new TamagotchiVlad(2));
            controller.feedAll();
            controller.cleanAll();
            controller.playAll();
        });
        Thread second = new Thread(() -> {
            controller.addVlad(new TamagotchiVlad(1));
            controller.playAll();
            controller.removeVlad(new TamagotchiVlad(1));
            controller.feedAll();
            controller.cleanAll();
            controller.sleepAll();
        });
        first.start();
        second.start();
    }
}