package faang.school.godbless.thirdSprint.Tamagotchi;

import java.util.ArrayList;
import java.util.List;

public class VladController {
    private final List<TamagotchiVlad> vlads = new ArrayList<>();

    public synchronized void addVlad(TamagotchiVlad vlad) {
        vlads.add(vlad);
    }

    public synchronized void deleteVlad(int vladId) {
        vlads.removeIf(vlad -> vlad.getVladId() == vladId);
    }

    public synchronized void feedAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.feed();
        }
    }

    public synchronized void playAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.play();
        }
    }

    public synchronized void cleanAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.clean();
        }
    }

    public synchronized void sleepAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.sleep();
        }
    }

    public synchronized void checkAll() {
        for (TamagotchiVlad vlad : vlads) {
            vlad.printVladState();
        }
    }
}
