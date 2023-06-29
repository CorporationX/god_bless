package Sprint_4_Task18;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        VladController controller = new VladController();

        TamagotchiVlad Vlad1 = new TamagotchiVlad("Vlad1");
        TamagotchiVlad Vlad2 = new TamagotchiVlad("Vlad2");
        TamagotchiVlad Vlad3 = new TamagotchiVlad("Vlad3");
        TamagotchiVlad Vlad4 = new TamagotchiVlad("Vlad4");

        controller.addTamagotchiVladList(Vlad1);
        controller.addTamagotchiVladList(Vlad2);
        controller.addTamagotchiVladList(Vlad3);
        controller.removeTamagotchiVladList(Vlad3);
        controller.addTamagotchiVladList(Vlad4);


        Thread thread1 = new Thread(() -> {
            controller.sleepAll();
            controller.playAll();
            controller.cleanAll();
            controller.feedAll();
        });
        Thread thread2 = new Thread(() -> {
            controller.cleanAll();
            controller.feedAll();
            controller.playAll();
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
