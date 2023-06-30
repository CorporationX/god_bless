package faang.school.godbless.task.goodgame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class PigThread extends Thread {
    private String pigName;
    private MaterialType material;

    public abstract void buildHouse() throws InterruptedException;

    @Override
    public void run() {
        try {
            buildHouse();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
