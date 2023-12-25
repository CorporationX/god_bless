package faang.school.godbless.multi_paral.task5tourney;

import java.util.Random;

public class Trial implements Runnable {
    private String knightName;
    private String trialName;
    private Knight knight;

    public Trial(Knight knight, String trialName) {
        this.knightName = knight.getName();
        this.trialName = trialName;
        this.knight = knight;
    }

    @Override
    public void run() {
        try {
            System.out.println(knightName + " начинает испытание: " + trialName);
            Thread.sleep(2000);

            int random = new Random().nextInt(2);
            if (random == 0) {
                System.out.println(knightName + " выиграл испытание: " + trialName);
                knight.setCountWin(knight.getCountWin() + 1);
            } else {
                System.out.println(knightName + " проиграл испытание: " + trialName);
            }
        } catch (InterruptedException e) {
            System.out.println("Испытание прервано");
        }
    }
}
