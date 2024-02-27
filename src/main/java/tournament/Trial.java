package tournament;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial implements  Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(knightName + " начал выполнять " + trialName);
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(knightName + " закончил выполнять " + trialName);
    }
}
