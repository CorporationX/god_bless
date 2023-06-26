package faang.school.godbless.thirdSprint.NormalGame;

import java.util.Random;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(2000));
            System.out.println(getPigName() + " привёз все " + getMaterial() + " и уже готов ложить фундамент");
            Thread.sleep(random.nextInt(500));
            System.out.println(getPigName() + " с невероятной скоростью положил фундамент и построил стены");
            Thread.sleep(random.nextInt(500));
            System.out.println("Готово! " + getPigName() + " построил свой дом.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
