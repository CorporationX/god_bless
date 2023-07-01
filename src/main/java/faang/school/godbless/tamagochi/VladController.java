package faang.school.godbless.tamagochi;

import java.util.List;

public class VladController {
    private List<TamagotchiVlad> tamagotchiList;

    public VladController(List<TamagotchiVlad> list){
        tamagotchiList = list;
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            try {
                tamagotchi.feed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            try {
                tamagotchi.play();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            try {
                tamagotchi.clean();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad tamagotchi : tamagotchiList) {
            try {
                tamagotchi.sleep();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
