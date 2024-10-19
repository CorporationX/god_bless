package school.faang.tamagotchi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private List<TamagotchiVlad> tamagotchis = new ArrayList<>();

    public synchronized void addTamagochi(TamagotchiVlad vlad) {
        tamagotchis.add(vlad);
        System.out.println(vlad.getName() + " добавлен в список.");
    }

    public synchronized void deleteTamagochi(TamagotchiVlad vlad) {
        tamagotchis.remove(vlad);
        System.out.println(vlad.getName() + " удалён из списка.");
    }

    public synchronized void feedAll() {
        tamagotchis.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        tamagotchis.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        tamagotchis.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        tamagotchis.forEach(TamagotchiVlad::sleep);
    }
}