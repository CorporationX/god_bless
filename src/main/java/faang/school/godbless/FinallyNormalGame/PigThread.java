package faang.school.godbless.FinallyNormalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public void run() {
        try {
            System.out.println("House is building...");
            Thread.sleep(new Random().nextInt(1000, 2000));
            System.out.println("House of " + this.getMaterial() + " was build");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
