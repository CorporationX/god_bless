package faang.school.godbless.TamagochiVlad;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class VladController {
    private final List<TamagochiVlad> tamagochis;

    public void feedAll() {
        synchronized (tamagochis) {
            tamagochis.forEach(TamagochiVlad::feed);
        }
    }

    public void playAll() {
        synchronized (tamagochis) {
            tamagochis.forEach(TamagochiVlad::play);
        }
    }

    public void cleanAll() {
        synchronized (tamagochis) {
            tamagochis.forEach(TamagochiVlad::clean);

        }
    }

    public void sleepAll() {
        synchronized (tamagochis) {
            tamagochis.forEach(TamagochiVlad::sleep);
        }
    }

    public void removeTamagochi(TamagochiVlad tamagochi) {
        synchronized (tamagochis) {
            tamagochis.remove(tamagochi);
        }
    }
}
