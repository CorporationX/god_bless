package faang.school.godbless.normalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private int material;

    @Override
    public void run() {
        System.out.printf("%s starts to build its house", this.getPigName());
        System.out.println();
        try {
            Thread.sleep(1000 * this.getMaterial());
            System.out.printf("%s's house is built!", this.getPigName());
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
