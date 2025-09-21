package school.faang.bjs2_89577;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public class Trial implements Runnable {
    private final String trialName;
    private final String knightName;

    private static final int TRIAL_DURATION_IN_SECONDS = 5;

    public Trial(String trialName, String knightName) {
        validateTrial(trialName, knightName);
        this.trialName = trialName;
        this.knightName = knightName;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Рыцарь %s проходит испытание \"%s\"...\n", knightName, trialName);
            TimeUnit.SECONDS.sleep(TRIAL_DURATION_IN_SECONDS);
            System.out.printf("%s прошел испытание!\n", knightName);
        } catch (InterruptedException e) {
            System.out.printf("%s возможно застрял... Испытание провелено - Королю такое не по вкусу!\n", knightName);
            Thread.currentThread().interrupt();
        }
    }

    private static void validateTrial(String trialName, String knightName) {
        if (trialName == null || trialName.isBlank()) {
            throw new IllegalArgumentException("Название испытания не может быть ни null, ни пустым!");
        }
        if (knightName == null || knightName.isBlank()) {
            throw new IllegalArgumentException("Имя рыцаря не может быть ни null, ни пустым!");
        }
    }
}
