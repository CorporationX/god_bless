package Sprint_4_Task9;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " trialName: " + trialName + " knightName: " + knightName);
    }
}
