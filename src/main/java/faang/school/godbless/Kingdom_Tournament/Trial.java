package faang.school.godbless.Kingdom_Tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(trialName + " begins! And the knight is ...: " + knightName);
    }
}
