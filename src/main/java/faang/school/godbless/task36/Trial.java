package faang.school.godbless.task36;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable{
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Рыцарь "+knightName + " выполняет испытание " + trialName);
    }
}
