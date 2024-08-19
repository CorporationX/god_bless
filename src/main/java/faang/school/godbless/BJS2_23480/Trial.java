package faang.school.godbless.BJS2_23480;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    @Override
    public void run() {
        System.out.println(getKnightName() + " выполняет испытание " + getTrialName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(getKnightName() + " был прерван во время выполнения " + getTrialName());
        }
        System.out.println(getKnightName() + " завершил испытание " + getTrialName());
    }
}
