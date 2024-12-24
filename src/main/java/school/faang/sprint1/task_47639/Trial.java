package school.faang.sprint1.task_47639;

import lombok.Getter;

@Getter
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    public Trial(String knightName, String trialName) {
        this.knightName = knightName;
        this.trialName = trialName;
    }

    @Override
    public void run() {
        try {
            System.out.println(knightName + " начал испытание " + trialName);
            Thread.sleep(3000);
            System.out.println("Рыцарь " + knightName + " завершил испытание " + trialName);
        } catch (InterruptedException e) {
            System.out.println("испытание прервано");
        }
    }
}
