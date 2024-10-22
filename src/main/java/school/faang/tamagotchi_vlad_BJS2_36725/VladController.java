package school.faang.tamagotchi_vlad_BJS2_36725;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class VladController {
    private List<TamagochiVlad> allTamagochies = new ArrayList<>();

    public synchronized void addTamagochi(TamagochiVlad tamagochi) {
        allTamagochies.add(tamagochi);
    }

    public synchronized void deleteTamagochi(TamagochiVlad tamagochi) {
        allTamagochies.remove(tamagochi);
    }

    public synchronized void feedAllTamagochi() {
        allTamagochies.forEach(TamagochiVlad::feed);
    }

    public synchronized void playAllTamagochi() {
        allTamagochies.forEach(TamagochiVlad::play);
    }

    public synchronized void cleanAllTamagochi() {
        allTamagochies.forEach(TamagochiVlad::clean);
    }

    public synchronized void sleepAllTamagochi() {
        allTamagochies.forEach(TamagochiVlad::sleep);
    }
}
