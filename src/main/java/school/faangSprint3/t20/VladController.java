package school.faangSprint3.t20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> vladList = Collections.synchronizedList(new ArrayList<>());

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vladList.add(vlad);
        System.out.println(vlad + " добавлен в список.");
    }

    public void feedAll() {
        synchronized (vladList) {
            for (TamagotchiVlad vlad : vladList) {
                vlad.feed();
            }
        }
    }

    public void playAll() {
        synchronized (vladList) {
            for (TamagotchiVlad vlad : vladList) {
                vlad.play();
            }
        }
    }

    public void cleanAll() {
        synchronized (vladList) {
            for (TamagotchiVlad vlad : vladList) {
                vlad.clean();
            }
        }
    }

    public void sleepAll() {
        synchronized (vladList) {
            for (TamagotchiVlad vlad : vladList) {
                vlad.sleep();
            }
        }
    }
}