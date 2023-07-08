package faang.school.godbless.tamagotchi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();

    public void addTamagotchi(TamagotchiVlad tamagotchiVlad) {
        synchronized (tamagotchiVladList) {
            tamagotchiVladList.add(tamagotchiVlad);
            System.out.println(tamagotchiVlad.getName() + " created");
        }
    }

    public void deleteTamagotchi(TamagotchiVlad tamagotchiVlad) {
        synchronized (tamagotchiVladList) {
            tamagotchiVladList.remove(tamagotchiVlad);
            System.out.println(tamagotchiVlad.getName() + " removed");
        }
    }

    public void feedAll() {
        synchronized (tamagotchiVladList) {
            for (TamagotchiVlad tamagotchi : tamagotchiVladList) {
                tamagotchi.feed();
            }
        }
    }

    public void playAll() {
        synchronized (tamagotchiVladList) {
            for (TamagotchiVlad tamagotchi : tamagotchiVladList) {
                tamagotchi.play();
            }
        }
    }

    public void cleanAll() {
        synchronized (tamagotchiVladList) {
            for (TamagotchiVlad tamagotchi : tamagotchiVladList) {
                tamagotchi.clean();
            }
        }
    }

    public void sleepAll() {
        synchronized (tamagotchiVladList) {
            for (TamagotchiVlad tamagotchi : tamagotchiVladList) {
                tamagotchi.sleep();
            }
        }
    }
}

