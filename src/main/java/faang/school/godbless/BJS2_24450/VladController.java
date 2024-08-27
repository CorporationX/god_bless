package faang.school.godbless.BJS2_24450;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VladController {
    private List<TamagotchiVlad> tamagotchiVlads;
    private ExecutorService executor;

    public VladController(List<TamagotchiVlad> tamagotchiVlads) {
        this.tamagotchiVlads = tamagotchiVlads;
        this.executor = Executors.newFixedThreadPool(tamagotchiVlads.size());
    }

    public synchronized void feedAll() {
        tamagotchiVlads.forEach(vlad -> executor.execute(vlad::feed));
    }

    public synchronized void playAll() {
        tamagotchiVlads.forEach(vlad -> executor.execute(vlad::play));
    }

    public synchronized void cleanAll() {
        tamagotchiVlads.forEach(vlad -> executor.execute(vlad::clean));
    }

    public synchronized void sleepAll() {
        tamagotchiVlads.forEach(vlad -> executor.execute(vlad::sleep));
        stopTamagotchiVlads();
    }

    private void stopTamagotchiVlads() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}