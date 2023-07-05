package faang.school.godbless.awesome_game;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.Random;

@Data
@EqualsAndHashCode(callSuper = true)
public class PigThread extends Thread {

    protected String pigName;
    protected String material;

    protected Random random = new Random();

    public PigThread(String name, String material) {
        this.pigName = name;
        this.material = material;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(getPigName() + " builds his house with " + getMaterial() + "...");
        Thread.sleep(random.nextInt(10_000));
        System.out.println(getPigName() + "'s house is built!");
    }
}