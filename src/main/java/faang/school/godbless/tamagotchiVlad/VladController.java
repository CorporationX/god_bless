package faang.school.godbless.tamagotchiVlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> tamagotchis;

    public VladController() {
        this.tamagotchis = new ArrayList<>();
    }

    public synchronized void addTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchis.add(tamagotchi);
    }

    public synchronized void removeTamagotchi(TamagotchiVlad tamagotchi) {
        tamagotchis.remove(tamagotchi);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad tamagotchi : tamagotchis) {
            tamagotchi.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad tamagotchi : tamagotchis) {
            tamagotchi.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad tamagotchi : tamagotchis) {
            tamagotchi.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad tamagotchi : tamagotchis) {
            tamagotchi.sleep();
        }
    }
}
