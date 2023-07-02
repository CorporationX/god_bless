package faang.school.godbless.tamagochi;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class VladController {
    List<TamagotchiVlad> tamagotchiVladList = getTamagotchiList();

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

    public synchronized void deleteTamagotchi() {
        TamagotchiVlad tamagotchiToRemove = tamagotchiVladList.get(0);
        tamagotchiVladList.remove(tamagotchiToRemove);
        System.out.println("Vlad #" + tamagotchiToRemove.getId() + " has been deleted");
    }

    public synchronized void addTamagotchi() {
        TamagotchiVlad tamagotchiVlad = new TamagotchiVlad();
        tamagotchiVladList.add(tamagotchiVlad);
        System.out.println("Vlad #" + tamagotchiVlad.getId() + " has been added");
    }

    private List<TamagotchiVlad> getTamagotchiList() {
        return new ArrayList<>(List.of(
                new TamagotchiVlad(),
                new TamagotchiVlad(),
                new TamagotchiVlad()
        ));
    }
}
