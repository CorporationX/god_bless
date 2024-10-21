package Sprint_3.BJS2_35781;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trial {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("испытание было прервано " + getTrialName());
        }
        System.out.println("испытание: " + getTrialName() + " Завершино");
    }
}
