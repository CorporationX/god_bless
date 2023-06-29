package faang.school.godbless.kxnvg.tamagochi;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TamagotchiVlad tamagotchi1 = new TamagotchiVlad();
        TamagotchiVlad tamagotchi2 = new TamagotchiVlad();
        TamagotchiVlad tamagotchi3 = new TamagotchiVlad();
        TamagotchiVlad tamagotchi4 = new TamagotchiVlad();
        TamagotchiVlad tamagotchi5 = new TamagotchiVlad();

        VladController controller = new VladController();
        controller.setTamagotchies(List.of(tamagotchi1, tamagotchi2, tamagotchi3, tamagotchi4, tamagotchi5));

        Thread thread1 = new Thread(() -> {
            controller.feedAll();
            controller.playAll();
            controller.cleanAll();
            controller.sleepAll();
        });
        Thread thread2 = new Thread(() -> {
            controller.playAll();
            controller.sleepAll();
            controller.playAll();
            controller.sleepAll();
        });

        thread1.start();
        thread2.start();
    }
}
