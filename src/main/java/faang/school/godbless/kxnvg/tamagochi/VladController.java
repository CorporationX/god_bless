package faang.school.godbless.kxnvg.tamagochi;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class VladController {

    @Setter
    @Getter
    private List<TamagotchiVlad> tamagotchies = new ArrayList<>();

    public void feedAll() {
        tamagotchies.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        tamagotchies.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        tamagotchies.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        tamagotchies.forEach(TamagotchiVlad::sleep);
    }

    public void addTamagothi(TamagotchiVlad tamagotchiVlad) {
        tamagotchies.add(tamagotchiVlad);
    }

    public synchronized boolean deleteTamagotchi(TamagotchiVlad tamagotchiVlad) {
        if (tamagotchies.contains(tamagotchiVlad)) {
            tamagotchies.remove(tamagotchiVlad);
            return true;
        }
        return false;
    }
}
