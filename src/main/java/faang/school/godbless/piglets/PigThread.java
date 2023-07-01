package faang.school.godbless.piglets;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;

    @Override
    public void run() {
        try {
            System.out.println(pigName + " started building a house from " + getMaterial());
            Thread.sleep(1500);
            System.out.println(pigName + " finished building a house from " + getMaterial());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
