package faang.school.godbless.multithreading.tamagochi;

import java.util.List;

public class TamagochiController {
    private final List<TamagochiVlad> tamagochies;
    private final Object lock = new Object();

    public TamagochiController(List<TamagochiVlad> tamagochies) {
        this.tamagochies = tamagochies;
    }

    public synchronized void addTamagochi(TamagochiVlad tamagochi) {
        tamagochies.add(tamagochi);
        System.out.println("Добавлен тамагочи: " + tamagochi.getName());
    }

    public synchronized void removeTamagochi(TamagochiVlad tamagochi) {
        tamagochies.remove(tamagochi);
        System.out.println("Удалён тамагочи: " + tamagochi.getName());
    }

    public synchronized void feedAll(String food) {
        tamagochies.forEach(tamagochi -> tamagochi.feed(food));
    }
    public synchronized void playAll(String game) {
        tamagochies.forEach(tamagochi -> tamagochi.play(game));

    }
    public synchronized void cleanAll() {
        tamagochies.forEach(TamagochiVlad::clean);
    }
    public synchronized void sleepAll() {
        tamagochies.forEach(TamagochiVlad::sleep);
    }
}
