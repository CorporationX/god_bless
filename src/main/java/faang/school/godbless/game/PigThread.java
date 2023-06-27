package faang.school.godbless.game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private int material;

    public String getMaterials() {
        if (getMaterial() == 1) {
            return "солома";
        } else if (getMaterial() == 2) {
            return "палки";
        } else if (getMaterial() == 3) {
            return "кирпичи";
        } else {
            return "Такого материала нет";
        }
    }
}
