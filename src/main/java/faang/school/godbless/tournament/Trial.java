package faang.school.godbless.tournament;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println("start");
            Thread.sleep(500);
            System.out.println("end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
