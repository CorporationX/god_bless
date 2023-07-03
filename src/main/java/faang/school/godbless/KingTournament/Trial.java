package faang.school.godbless.KingTournament;

import lombok.Getter;

@Getter
public class Trial extends Thread {

    private String knightName;
    private String trialName;

    public Trial(String trialName, String knightName) {
        this.trialName = trialName;
        this.knightName = knightName;
    }

    @Override
    public void run() {
        System.out.println("Испытание " + trialName + " выполнено рыцарем: "  + knightName);
    }
}
