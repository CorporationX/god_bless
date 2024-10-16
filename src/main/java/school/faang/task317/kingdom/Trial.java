package school.faang.task317.kingdom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        try {
            System.out.println(String.format("Рыцарь %s начал испытание %s", knightName, trialName));
            Thread.sleep(3000);
            System.out.println(String.format("Рыцарь %s закончил испытание %s", knightName, trialName));
        } catch (InterruptedException e) {
            System.out.println(String.format("Рыцарь %s не смог закончить испытание %s", knightName, trialName));
            throw new RuntimeException(e);
        }
    }
}
