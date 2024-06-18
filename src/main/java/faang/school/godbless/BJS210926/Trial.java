package faang.school.godbless.BJS210926;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trial  implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run(){
        try {
            System.out.println("Name of thread is running = " + Thread.currentThread().getName() );
            System.out.println("Trial - " + trialName + " of knight " + knightName + " is running");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
