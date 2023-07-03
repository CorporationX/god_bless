package faang.school.godbless.multithreading.tamagochi;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class VladController {
    private final Object lock;
    private final List<TamagochiVlad> tamagochiVladList;

    public VladController() {
        lock = new Object();
        tamagochiVladList = new ArrayList<>();
    }

    public void addTamagochiVlad(TamagochiVlad tamagochiVlad) {
        synchronized (lock) {
            tamagochiVladList.add(tamagochiVlad);
        }
    }

    public void removeTamagochiVlad(TamagochiVlad tamagochiVlad) {
        synchronized (lock) {
            tamagochiVladList.remove(tamagochiVlad);
        }
    }

    public void feedALL() {
        tamagochiVladList.forEach(TamagochiVlad::feed);
    }

    public void playALL() {
        tamagochiVladList.forEach(TamagochiVlad::play);
    }

    public void cleanALL() {
        tamagochiVladList.forEach(TamagochiVlad::clean);
    }

    public void sleepALL() {
        tamagochiVladList.forEach(TamagochiVlad::sleep);
    }
}
