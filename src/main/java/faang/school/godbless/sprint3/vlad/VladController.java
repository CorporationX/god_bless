package faang.school.godbless.sprint3.vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();

    public void createVlad(TamagotchiVlad tamagotchi) {
        tamagotchiVlads.add(tamagotchi);
        System.out.println("Tamagotchi created");
    }

    public void deleteVlad(TamagotchiVlad tamagotchi) {
        tamagotchiVlads.remove(tamagotchi);
        System.out.println("Tamagotchi deleted");
    }
    public synchronized void feedAll() {
        for (TamagotchiVlad tamago : tamagotchiVlads) {
            tamago.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad tamago : tamagotchiVlads) {
            tamago.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad tamago : tamagotchiVlads) {
            tamago.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad tamago : tamagotchiVlads) {
            tamago.sleep();
        }
    }
}
