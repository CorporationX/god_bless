package faang.school.godbless.tamagotchi;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private List<TamagotchiVlad> tamagotchiList = new ArrayList<>();

    public synchronized void addTamagochi(TamagotchiVlad tamagotchi) {
        System.out.println("Добавляем тамагоч " + tamagotchi.getName());
        tamagotchiList.add(tamagotchi);
    }

    public synchronized void removeTamagochi(TamagotchiVlad tamagotchi) {
        System.out.println("Удаляем тамагоч " + tamagotchi.getName());
        tamagotchiList.remove(tamagotchi);
    }

    public synchronized void feedAll() throws InterruptedException {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.feed();
        }
    }

    public synchronized void sleepAll() throws InterruptedException {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.sleep();
        }
    }

    public synchronized void playAll() throws InterruptedException {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.play();
        }
    }

    public void cleanAll() throws InterruptedException {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            tamagotchi.clean();
        }
    }

}
