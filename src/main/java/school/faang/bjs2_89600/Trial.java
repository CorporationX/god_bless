package school.faang.bjs2_89600;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Trial implements Runnable {
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    private final int TRIAL_DURATION = 7000;
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Испытание началось!");
        try {
            Thread.sleep(TRIAL_DURATION);
            System.out.println("Победил победитель, наградили наградой, подарили подарок.");
        } catch (InterruptedException e) {
            throw new RuntimeException("Испытание не закончилось, прервалось посередине");
        }
    }
}
