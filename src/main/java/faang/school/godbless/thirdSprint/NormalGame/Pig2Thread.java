package faang.school.godbless.thirdSprint.NormalGame;

import java.util.Random;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Нуф-Нуф", "палки");
    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
            System.out.println(getPigName() + " успешно сделал пол и начал строить стены");
            Thread.sleep(random.nextInt(1000));
            System.out.println("Стены сделаны! Осталось сделать крышу из " + getMaterial());
            Thread.sleep(random.nextInt(1000));
            System.out.println("Готово! " + getPigName() + " построил свой дом.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
