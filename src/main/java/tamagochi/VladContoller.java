package tamagochi;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class VladContoller {
    private final List<TamagochiVlad> tamagochiList = new ArrayList<>();
    private final ExecutorService executor;

    public synchronized void addTamagochi(@NonNull TamagochiVlad tamagochiVlad) {
        tamagochiList.add(tamagochiVlad);
    }

    public synchronized void removeTamagochi(@NonNull TamagochiVlad tamagochiVlad) {
        tamagochiList.remove(tamagochiVlad);
    }

    public void feedAll() {
        tamagochiList.forEach(vlad -> executor.execute(vlad::feed));
    }

    public void playAll() {
        tamagochiList.forEach(vlad -> executor.execute(vlad::play));
    }

    public void cleanAll() {
        tamagochiList.forEach(vlad -> executor.execute(vlad::clean));
    }

    public void sleepAll() {
        tamagochiList.forEach(vlad -> executor.execute(vlad::sleep));
    }
}
