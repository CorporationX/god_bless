package faang.school.godbless.BJS2_23497;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable {
    private final String knightName;
    private final String trialName;

    @Override
    public void run() {
        System.out.printf("Рыцарь %s начал прохождение испытания: %s%n", knightName, trialName);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.err.println("Испытание прервано: " + exception.getMessage());
        }

        System.out.printf("Рыцарь %s завершил испытание: %s%n", knightName, trialName);
    }
}
