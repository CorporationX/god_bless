package faang.school.godbless.hashmap.gameofthetrons;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println(knightName + " выполняет испытание " + trialName);
    }
}
