package faang.school.godbless.thirdSprint.NormalGame;

import java.util.concurrent.ThreadLocalRandom;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Нуф-Нуф", "палки");
    }

    @Override
    public void run() {
        logPigThreadStarted();
        int randomNum1 = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(randomNum1);
            System.out.println(getPigName() + " успешно сделал пол и начал строить стены");
            Thread.sleep(randomNum1);
            System.out.println("Стены сделаны! Осталось сделать крышу из " + getMaterial());
            Thread.sleep(randomNum1);
            System.out.println("Готово! " + getPigName() + " построил свой дом.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
