package tournament;

import lombok.ToString;

@ToString
public class Trial  implements Runnable{
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(knightName + " начал испытание - " + trialName);
    }

}
