package faang.school.godbless.synchronizationWaitNotify.tamagotchiVlad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@AllArgsConstructor
public class VladController {
    @Setter
    private List<TamagotchiVlad> tamagotchiVladList;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public VladController() {
        this.tamagotchiVladList = new ArrayList<>();
    }

    public synchronized void addTamagotchi(TamagotchiVlad tamagotchiVlad) {
        tamagotchiVladList.add(tamagotchiVlad);
        System.out.printf("Поток: %s. Тамагочи %s был добавлен.\n", Thread.currentThread().getName(), tamagotchiVlad.getName());
    }

    public synchronized void deleteTamagotchi(TamagotchiVlad tamagotchiVlad) {
        if (tamagotchiVladList.isEmpty()) {
            return;
        }

        tamagotchiVladList.removeIf(tamagotchiVlad1 -> tamagotchiVlad1.getName().equals(tamagotchiVlad.getName()));
        System.out.printf("Поток: %s. Тамагочи %s был удален.\n", Thread.currentThread().getName(), tamagotchiVlad.getName());
    }

    public synchronized void feedAll() {
        tamagotchiVladList.forEach(tamagotchiVlad -> executorService.execute(tamagotchiVlad::feed));
    }

    public synchronized void playAll() {
        tamagotchiVladList.forEach(tamagotchiVlad -> executorService.execute(tamagotchiVlad::play));
    }

    public synchronized void cleanAll() {
        tamagotchiVladList.forEach(tamagotchiVlad -> executorService.execute(tamagotchiVlad::clean));
    }

    public synchronized void sleepAll() {
        tamagotchiVladList.forEach(tamagotchiVlad -> executorService.execute(tamagotchiVlad::sleep));
    }

    public void complete() {
        executorService.shutdown();
    }
}
