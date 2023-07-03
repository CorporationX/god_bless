package faang.school.godbless.kxnvg.kingslanding;

import lombok.NonNull;
import lombok.Setter;

public class Trial extends Thread {

    @Setter
    private String knightName;
    @NonNull
    private String trialName;

    public Trial(String trialName) {
        this.trialName = trialName;
    }

    @Override
    public void run() {
        System.out.println(knightName + " выполнил испытание " + trialName);
    }
}
