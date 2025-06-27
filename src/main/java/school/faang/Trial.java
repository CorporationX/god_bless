package school.faang;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.Callable;

@Data
@AllArgsConstructor
public class Trial implements Callable<Trial> {
    private String trialName;
    private String knightName;

    @Override
    public Trial call() throws Exception {
        System.out.println("Испытание " +  trialName + " началось");
        Thread.sleep(2000);
        System.out.println("Испытание " +  trialName + " закончилось");
        return null;
    }
}
