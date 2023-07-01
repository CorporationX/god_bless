package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class PigThread extends Thread {
    protected String pigName;
    protected String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    @Override
    public void run() {
        System.out.printf("%s starts building his house with %s\n", pigName, material);
        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has done\n", pigName);
    }
}
