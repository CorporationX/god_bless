package faang.school.godbless.thirdSprint.NormalGame;

import java.util.Random;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
            System.out.println(getPigName() + " сделал блоки из соломы нужного размера, осталось соединить их.");
            Thread.sleep(random.nextInt(2000));
            System.out.println("Готово! " + getPigName() + " построил свой дом.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
