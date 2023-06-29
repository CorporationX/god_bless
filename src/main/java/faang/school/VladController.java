package faang.school;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VladController {
    List<TamagotchiVlad> toys;

    public void addToy(TamagotchiVlad toy) {
        toys.add(toy);
    }

    public synchronized void feedAll() {
        System.out.println("feed All");
        toys.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        System.out.println("play All");
        toys.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        System.out.println("clean All");
        toys.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        System.out.println("sleep All");
        toys.forEach(TamagotchiVlad::sleep);
    }
}
