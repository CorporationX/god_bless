package faang.school.godbless.TamagotchiVlad;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class TamagotchiController {
    private List<TamagotchiVlad> list = new ArrayList<>();

    public synchronized void add() {
        TamagotchiVlad tamagotchiVlad = new TamagotchiVlad(new Random(1000).nextInt());
        list.add(tamagotchiVlad);
        System.out.println("Tamagotchi vlad with id " + tamagotchiVlad.getId() + " has been added");
    }

    public synchronized void delete() {
        System.out.println("Tamagotchi vlad with id " + list.get(0).getId() + " has been deleted");
        list.remove(0);
    }

    public synchronized void feedAll() {
        list.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        list.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        list.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        list.forEach(TamagotchiVlad::sleep);
    }
}
