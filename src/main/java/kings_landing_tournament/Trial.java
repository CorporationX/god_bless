package kings_landing_tournament;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Trial implements Runnable{
    private String knightName;
    private String trialName;
    public Trial(String trialName){
        this.trialName = trialName;
    }
    public void run(){
        System.out.println(getKnightName()+" начал выполнять испытание "+getTrialName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((getKnightName()+" прошел испытание "+getTrialName()));
    }
}
