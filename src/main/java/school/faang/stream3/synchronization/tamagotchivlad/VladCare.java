package school.faang.stream3.synchronization.tamagotchivlad;

import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@RequiredArgsConstructor
public class VladCare implements Runnable {
    private final VladController controller;

    @Override
    public void run() {
        while (true) {
            synchronized (controller.getTamagotchiList()) {
                while (controller.getTamagotchiList()
                        .stream().anyMatch(tamagotchiVlad -> tamagotchiVlad.getIsAlive().get())) {
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    controller.feedAll();
                    controller.sleepAll();
                    controller.cleanAll();
                    controller.playAll();
                }
            }
        }
    }
}