package mod1sp3.tamagotchiVlad;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VladController {
    private final List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();

    public synchronized void addNewTamogotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
    }

    public synchronized void removeTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.remove(tamagotchiVlad);
    }

    public synchronized void feedAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::sleep);
    }
}
