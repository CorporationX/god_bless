package faang.school.godbless.tamagotchi_vlad;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private List<TamagotchiVlad> vlads = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
        notifyAll();
    }

    public synchronized void deleteVlad(TamagotchiVlad vlad) {
        if(vlads.isEmpty()) {
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        vlads.remove(vlad);
    }

    public synchronized void feedAll() {
        vlads.forEach(TamagotchiVlad :: feed);
    }

    public synchronized void playAll() {
        vlads.forEach(TamagotchiVlad :: play);
    }

    public synchronized void cleanAll() {
        vlads.forEach(TamagotchiVlad :: clean);
    }

    public synchronized void sleepAll() {
        vlads.forEach(TamagotchiVlad :: sleep);
    }
}
