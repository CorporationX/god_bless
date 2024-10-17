package school.faang.m1s3.bjs2_36715_tamagochi;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VladController {
    private final List<TamagotchiVlad> vlads = new ArrayList<>();

    public void addTamagotchi(TamagotchiVlad tamagotchiVlad) {
        vlads.add(tamagotchiVlad);
    }

    public void deleteTamagotchi(String name) {
        vlads.remove(new TamagotchiVlad(name));
    }

    public void feedAll() {
        vlads.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        vlads.forEach(TamagotchiVlad::play);
    }

    public void cleanAll() {
        vlads.forEach(TamagotchiVlad::clean);
    }

    public void sleepAll() {
        vlads.forEach(TamagotchiVlad::sleep);
    }
}
