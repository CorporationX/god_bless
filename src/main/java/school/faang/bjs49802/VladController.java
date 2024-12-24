package school.faang.bjs49802;

import java.util.ArrayList;
import java.util.List;

public class VladController {

    private List<TamagotchiVlad> vlaushki = new ArrayList<>();

    public void feedAll() {
        vlaushki.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        vlaushki.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        vlaushki.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        vlaushki.forEach(TamagotchiVlad::sleep);
    }

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vlaushki.add(vlad);
        System.out.println(vlad + " добавлен в список.");
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vlaushki.remove(vlad);
        System.out.println(vlad + " удалён из списка.");
    }

}
