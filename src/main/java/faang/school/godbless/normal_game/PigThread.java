package faang.school.godbless.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {

    private String pigName;
    private int material;

    @Override
    public void run() {
        System.out.println(getPigName() + " has started to build the house from " + getMaterial());

        try {
            Thread.sleep(getBuildingTime());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(getPigName() + " has finished the house from " + getMaterialName(getMaterial()));
    }

    public String getMaterialName(int material) {
        if (material == 1) {
            return "straw";
        } else if (material == 2) {
            return "wood";
        } else if (material == 3) {
            return "brick";
        } else {
            return "undefined material";
        }
    }

    private int getBuildingTime() {
        if (material == 1) {
            return 1000;
        } else if (material == 2) {
            return 3000;
        } else if (material == 3) {
            return 5000;
        } else {
            return -1;
        }
    }
}
