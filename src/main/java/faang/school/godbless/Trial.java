package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread | Knight " + knightName + " is performing trial: " + trialName);
    }
}
