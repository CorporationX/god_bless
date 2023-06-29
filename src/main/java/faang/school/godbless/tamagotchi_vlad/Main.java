package faang.school.godbless.tamagotchi_vlad;

public class Main {
    public static void main(String[] args) {
        TamagotchiVlad vlad1 = new TamagotchiVlad();
        TamagotchiVlad vlad2 = new TamagotchiVlad();
        TamagotchiVlad vlad3 = new TamagotchiVlad();
        TamagotchiVlad vlad4 = new TamagotchiVlad();

        VladController controller = new VladController();
        controller.addVlad(vlad1);
        controller.addVlad(vlad2);
        controller.addVlad(vlad3);
        controller.addVlad(vlad4);

        Thread thread1 = new Thread(() -> {
            controller.sleepAll();
            controller.cleanAll();
            controller.deleteVlad(vlad2);
        });

        Thread thread2 = new Thread(() -> {
           controller.playAll();
           controller.feedAll();
        });

        thread1.start();
        thread2.start();
    }
}
