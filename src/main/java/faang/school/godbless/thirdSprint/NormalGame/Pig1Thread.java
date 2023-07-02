package faang.school.godbless.thirdSprint.NormalGame;

import java.util.concurrent.ThreadLocalRandom;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        logPigThreadStarted();
        int randomNum1 = ThreadLocalRandom.current().nextInt(2000);
        int randomNum2 = ThreadLocalRandom.current().nextInt(1000);
        try {
            Thread.sleep(randomNum1);
            System.out.println(getPigName() + " сделал блоки из соломы нужного размера, осталось соединить их.");
            Thread.sleep(randomNum2);
            System.out.println("Готово! " + getPigName() + " построил свой дом.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
