package faang.school.godbless.normal.game;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private int material;
    private Map<Integer, String> materialID;

    @Override
    public void run() {
        System.out.println("Поросёнок " + this.getPigName() + " вспомнил про дедлайн и начал строить дом из " + this.getMaterialID().get(getMaterial()));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Поросёнок " + this.getPigName() + " построил дом из " + this.getMaterialID().get(getMaterial()));
    }
}
