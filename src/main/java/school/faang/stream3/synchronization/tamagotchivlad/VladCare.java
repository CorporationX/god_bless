package school.faang.stream3.synchronization.tamagotchivlad;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VladCare implements Runnable {
    private final VladController controller;

    @Override
    public void run() {
        while (!controller.getTamagotchiList().isEmpty()) {
            controller.feedAll();
            controller.sleepAll();
            controller.cleanAll();
            controller.playAll();
        }
    }
}