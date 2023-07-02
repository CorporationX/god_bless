package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
public class VladController {
    private List<TamagotchiVlad> vladList;

    public VladController() {
        vladList = new ArrayList<>();
    }
    public synchronized void addTamagotchiVlad(TamagotchiVlad vlad) {
        vladList.add(vlad);
    }

    public synchronized void removeTamagotchiVlad(TamagotchiVlad vlad) {
        vladList.remove(vlad);
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

    public synchronized void updateVladStatus() {
        for (TamagotchiVlad vlad : vladList) {
            if (vlad.isHungry()) {
                System.out.println(vlad.getName() + " is hungry.");
            }
            if (vlad.isDirty()) {
                System.out.println(vlad.getName() + " is dirty.");
            }
            if (vlad.isSleeping()) {
                System.out.println(vlad.getName() + " is sleeping.");
            }
        }
    }
}
