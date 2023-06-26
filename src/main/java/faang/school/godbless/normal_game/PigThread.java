package faang.school.godbless.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {

    private String pigName;
    private int material;

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
}
