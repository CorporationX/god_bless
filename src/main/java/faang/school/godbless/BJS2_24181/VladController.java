package faang.school.godbless.BJS2_24181;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VladController {
    private final List<TamagotchiVlad> vlads;

    public synchronized void removeVlad(TamagotchiVlad vlad) {
        vlads.remove(vlad);
    }

    public synchronized void feedAll() {
        vlads.forEach(TamagotchiVlad::feed);
    }

    public synchronized void playAll() {
        vlads.forEach(TamagotchiVlad::play);
    }

    public synchronized void cleanAll() {
        vlads.forEach(TamagotchiVlad::clean);
    }

    public synchronized void sleepAll() {
        vlads.forEach(TamagotchiVlad::sleep);
    }

}
