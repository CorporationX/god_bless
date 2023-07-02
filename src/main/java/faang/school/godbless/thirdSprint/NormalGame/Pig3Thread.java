package faang.school.godbless.thirdSprint.NormalGame;

import java.util.concurrent.ThreadLocalRandom;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }

    @Override
    public void run() {
        logPigThreadStarted();
        int randomNum1 = ThreadLocalRandom.current().nextInt(2000);
        int randomNum2 = ThreadLocalRandom.current().nextInt(500);
        try {
            Thread.sleep(randomNum1);
            System.out.println(getPigName() + " привёз все " + getMaterial() + " и уже готов ложить фундамент");
            Thread.sleep(randomNum2);
            System.out.println(getPigName() + " с невероятной скоростью положил фундамент и построил стены");
            Thread.sleep(randomNum2);
            System.out.println("Готово! " + getPigName() + " построил свой дом.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
