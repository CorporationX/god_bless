package faang.school.godbless.sprint3.BJS2_23457;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.printf("Knight %s is trying to get through trial %s %n", knightName, trialName);
    }
}
