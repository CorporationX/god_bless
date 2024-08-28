package faang.school.godbless.sprint3.BJS2_24191;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.stream.IntStream;

@Slf4j
public class VladMain {
    public static void main(String[] vladArgs) {
        VladController vladController = new VladController();

        IntStream.range(0, 5)
                .forEach(i -> vladController.addVlad(new TamagotchiVlad()));

        VladThread vladThread1 = new VladThread(() -> {
            vladController.feedAll();
            vladController.cleanAll();
            vladController.playAll();
            vladController.sleepAll();
        });

        VladThread vladThread2 = new VladThread(() -> {
            vladController.playAll();
            vladController.sleepAll();
            vladController.playAll();
            vladController.sleepAll();
        });

        vladThread1.vladStart();
        vladThread2.vladStart();

        try {
            vladThread1.joinVlad();
            vladThread2.joinVlad();
        } catch (InterruptedVladException vladException) {
            Thread.currentThread().interrupt();
            log.error(vladException.getVladMessage());
        } finally {
            if (!Thread.currentThread().isInterrupted()) {
                vladController.printVlads();
            }
        }

    }
}
