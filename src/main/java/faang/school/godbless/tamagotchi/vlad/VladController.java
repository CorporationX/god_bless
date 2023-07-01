package faang.school.godbless.tamagotchi.vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();

    public void addTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVlads.add(tamagotchiVlad);
        System.out.println("Добавлено новое тамагочи");
    }

    public void removeTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVlads.remove(tamagotchiVlad);
        System.out.println("Тамагочи удалено");

    }

    public void feedAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
            tamagotchiVlad.feed();
        }
    }

    public void playAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
            tamagotchiVlad.play();
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
            tamagotchiVlad.clean();
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVlads) {
            tamagotchiVlad.sleep();
        }
    }
}
