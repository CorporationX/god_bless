package faang.school.godbless.synchronize.tamagochiVlad;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VladController {
    private List<TamagotchiVlad> tamagotchiVladList;

    public void addTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
        System.out.println("Added " + tamagotchiVlad.getName());
    }

    public void removeTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.remove(tamagotchiVlad);
        System.out.println("Removed " + tamagotchiVlad.getName());
    }

    public void feedAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::feed);
    }

    public void playAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::play);
    }

    public void sleepAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::sleep);
    }

    public void cleanAll() {
        tamagotchiVladList.forEach(TamagotchiVlad::clean);
    }
}
