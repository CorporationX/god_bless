package faang.school.godbless.normal_game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PigThread extends Thread {
    private String pigName;
    private int material;
    private String[] materials = {"Кирпичи", "Бревна", "Солома"};

    public PigThread(String pigName, int material) {
        this.pigName = pigName;
        this.material = material;
    }
}
