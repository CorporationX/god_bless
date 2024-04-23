package faang.school.godbless.tamagochi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    List<TamagotchiVlad> vladList = new ArrayList<>();

    public synchronized void addTamagochi(TamagotchiVlad tamagotchiVlad) {
        if (!vladList.contains(tamagotchiVlad)) {
            vladList.add(tamagotchiVlad);
        }
    }

    public synchronized void removeTamagotchi(TamagotchiVlad tamagotchiVlad) {
        vladList.remove(tamagotchiVlad);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            synchronized (tamagotchiVlad) {
                if (!tamagotchiVlad.isSleeping()) {
                    tamagotchiVlad.feed();
                } else {
                    System.out.println("Сначала разбуди");
                }
            }
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            synchronized (tamagotchiVlad) {
                if (!tamagotchiVlad.isSleeping() && !tamagotchiVlad.isDirty() && !tamagotchiVlad.isHungry()) {
                    tamagotchiVlad.play();
                } else {
                    System.out.println("Не до игр");
                }
            }
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            synchronized (tamagotchiVlad) {
                if (!tamagotchiVlad.isSleeping()) {
                    tamagotchiVlad.clean();
                } else {
                    System.out.println("Сначала разбуди");
                }
            }
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            synchronized (tamagotchiVlad) {
                if (!tamagotchiVlad.isSleeping()) {
                    tamagotchiVlad.sleep();
                } else {
                    System.out.println("Уже спит");
                }
            }
        }
    }

    public synchronized void wakeUpAll() {
        for (TamagotchiVlad tamagotchiVlad : vladList) {
            synchronized (tamagotchiVlad) {
                if (tamagotchiVlad.isSleeping()) {
                    tamagotchiVlad.wakeUp();
                } else {
                    System.out.println("Итак не спит");
                }
            }
        }

    }
}