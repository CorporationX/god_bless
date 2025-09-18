package school.faang.multithreading_parallelism_thread.bjs2_91292;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;

    public void buildThread(int delayThread) {
        System.out.println(getPigName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(delayThread);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " закончил строить дом из " + getMaterial());
    }
}
