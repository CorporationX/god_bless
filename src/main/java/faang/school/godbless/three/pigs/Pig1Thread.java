package faang.school.godbless.three.pigs;

import java.util.List;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        for (int i = 0; i < getMaterial(); i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("дом поросёнка " + getPigName() + " " + " построен на " + i);

        }
    }
}
