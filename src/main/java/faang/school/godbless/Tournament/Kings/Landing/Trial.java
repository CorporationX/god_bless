package faang.school.godbless.Tournament.Kings.Landing;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Trial implements Runnable {

    private String knightName;
    private String trialName;

    public Trial(String trialName) {
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println("Рыцарь:" + knightName + " проходит испытание: " + trialName);
    }
}
