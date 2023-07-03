package tamagotchi_vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private List<TamagotchiVlad> vladList;

    public VladController() {
        this.vladList = new ArrayList<>();
    }

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vladList.add(vlad);
        System.out.println(vlad.getName() + " has been added");
    }

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        if (vladList.contains(vlad)) {
            vladList.remove(vlad);
            System.out.println(vlad.getName() + " has been removed");
        }else {
            System.out.println(vlad.getName() + " doesn't exist");
        }
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.sleep();
        }
    }

    public synchronized void wakeUpAll() {
        for (TamagotchiVlad vlad : vladList) {
            vlad.wakeUp();
        }
    }
}
