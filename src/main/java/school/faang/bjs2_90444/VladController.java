package school.faang.bjs2_90444;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> vladList = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vladList.add(vlad);
        System.out.printf("%s добавлен в список.", vlad);
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vladList.remove(vlad);
        System.out.printf("%s удалён из списка.", vlad);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            tamagotchiVlad.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            tamagotchiVlad.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            tamagotchiVlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            tamagotchiVlad.sleep();
        }
    }
}
