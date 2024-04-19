package faang.school.godbless.bjs2_5705;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VladController {

    private final List<TamagotchiVlad> tamagotchiVladList = new CopyOnWriteArrayList<>();

    public void addTamagotchiVlad(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
    }

    public void removeTamagotchiVlad(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.remove(tamagotchiVlad);
    }

    public void feedAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::sleep);
    }
}
