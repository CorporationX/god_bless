package bjs2_90135;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> vladList = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vladList.add(vlad);
        System.out.println(vlad + " добавлен в список.");
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vladList.remove(vlad);
        System.out.println(vlad + " удалён из списка.");
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.sleep();
        }
    }
}
