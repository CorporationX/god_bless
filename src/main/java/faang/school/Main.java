package faang.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VladController controller = new VladController(new ArrayList<>());

        TamagotchiVlad vlad1 = new TamagotchiVlad(1);
        TamagotchiVlad vlad2 = new TamagotchiVlad(2);
        TamagotchiVlad vlad3 = new TamagotchiVlad(3);

        controller.addToy(vlad1);
        controller.addToy(vlad2);
        controller.addToy(vlad3);

        controller.feedAll();
        controller.playAll();
        controller.cleanAll();
        controller.sleepAll();
    }
}
