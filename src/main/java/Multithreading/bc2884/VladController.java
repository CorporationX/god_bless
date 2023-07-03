package Multithreading.bc2884;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class VladController {
    public static List<TamagotchiVlad> tamagotchiVladList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            tamagotchiVladList.add(new TamagotchiVlad(i));
        }

    }


    public void addTamagochi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
    }

    public void removeTamagochi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.remove(tamagotchiVlad);
    }

    public void feedAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.feed();
        }
    }

    public void playAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.play();
        }
    }

    public void cleanAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.clean();
        }
    }

    public void sleepAll() {
        for (TamagotchiVlad tamagotchiVlad : tamagotchiVladList) {
            tamagotchiVlad.sleep();
        }
    }
}
