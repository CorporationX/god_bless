package faang.school.godbless.threads.norm_game;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }
}
