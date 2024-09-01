package faang.school.godbless.BJS2_24181;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VladController {
    private final List<TamagotchiVlad> vlads;

    public void removeVlad(TamagotchiVlad vlad) {
        synchronized (vlads) {
            vlads.remove(vlad);
        }
    }

    public void feedAll() {
        synchronized (vlads) {
            vlads.forEach(TamagotchiVlad::feed);
        }
    }

    public void playAll() {
        synchronized (vlads) {
            vlads.forEach(TamagotchiVlad::play);
        }
    }

    public void cleanAll() {
        synchronized (vlads) {
            vlads.forEach(TamagotchiVlad::clean);
        }
    }

    public void sleepAll() {
        synchronized (vlads) {
            vlads.forEach(TamagotchiVlad::sleep);
        }
    }

}
