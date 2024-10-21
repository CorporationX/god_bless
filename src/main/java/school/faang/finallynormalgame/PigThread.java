package school.faang.finallynormalgame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PigThread extends Thread {
    private final String pigName;
    private final String material;

    @Override
    public void run() {
        try {
            buildHouse();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(pigName + " was interrupted while building.");
        }
    }

    protected abstract void buildHouse() throws InterruptedException;
}
