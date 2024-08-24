package faang.school.godbless.BJS2_23361;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class PigThread extends Thread {

    private final String pigName;
    private final String material;
    private final long buildTime;

    @Override
    public void run() {
        System.out.println(getPigName() + " started  building a house out of " + getMaterial());

        try {
            Thread.sleep(buildTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The house of " + getMaterial() + " is built");
    }
}
