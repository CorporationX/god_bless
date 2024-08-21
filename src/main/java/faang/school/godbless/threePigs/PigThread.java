package faang.school.godbless.threePigs;

import lombok.Getter;

@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }
}
