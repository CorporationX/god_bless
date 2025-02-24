package school.faang.BJS235759;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trial implements Runnable {
    private String knightName;
    private String trialName;

    @Override
    public void run() {
        System.out.println("Рыцарь " + knightName + " Проходит испытание: " + trialName);
        try {
            Thread.sleep(3000);
            System.out.println(knightName + " Прошел испытание: " + trialName);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
}
