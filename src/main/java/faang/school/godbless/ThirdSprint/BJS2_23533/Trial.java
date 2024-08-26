package faang.school.godbless.ThirdSprint.BJS2_23533;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Trial implements Runnable{
    private String knightName;
    @NonNull
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " start " + trialName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(knightName + " end " + trialName);
    }
}
