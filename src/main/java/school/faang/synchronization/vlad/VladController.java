package school.faang.synchronization.vlad;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VladController {
    private List<TamagotchiVlad> vladList;

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
}
