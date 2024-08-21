package tournament.king.landing;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private static final int TRIAL_DELAY = 2000;
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf(
            "Рыцарь по имени %s приступил к выполнению испытания '%s'\n",
            this.knightName,
            this.trialName
        );

        try {
            Thread.sleep(TRIAL_DELAY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.printf(
            "Рыцарь по имени %s выполнил испытание '%s'\n",
            this.knightName,
            this.trialName
        );
    }
}
