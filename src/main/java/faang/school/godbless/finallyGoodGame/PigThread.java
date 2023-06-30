package faang.school.godbless.finallyGoodGame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println(
                this.getPigName() + " started building a house with " + this.getMaterial()
        );

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                this.getPigName() + " has builded a house with " + this.getMaterial()
        );
    }
}
