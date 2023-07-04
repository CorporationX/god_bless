package faang.school.godbless.synchronize.tamagochiVlad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();
        tamagotchiVladList.add(TamagotchiVlad.Factory.create());
        tamagotchiVladList.add(TamagotchiVlad.Factory.create());
        tamagotchiVladList.add(TamagotchiVlad.Factory.create());
        tamagotchiVladList.add(TamagotchiVlad.Factory.create());
        tamagotchiVladList.add(TamagotchiVlad.Factory.create());
        tamagotchiVladList.add(TamagotchiVlad.Factory.create());

        VladController controller = new VladController(tamagotchiVladList);

        Thread t1 = new Thread(controller::feedAll);
        Thread t2 = new Thread(controller::playAll);
        Thread t3 = new Thread(controller::sleepAll);
        Thread t4 = new Thread(controller::cleanAll);
        Thread t5 = new Thread(controller::feedAll);
        Thread t6 = new Thread(controller::playAll);
        Thread t7 = new Thread(() -> {
            controller.addTamagotchi(new TamagotchiVlad("Semen"));
        });
        Thread t8 = new Thread(() -> {
            controller.removeTamagotchi(tamagotchiVladList.get(0));
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
