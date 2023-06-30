package faang.school.godbless.finallyNormalGame;

import lombok.Data;

@Data
public class PigThread extends Thread {
    private String pigName;
    private int material; // материал для посторойки

    public PigThread(String pigName, int material) {
        this.pigName = pigName;
        this.material = material;
    }
}
