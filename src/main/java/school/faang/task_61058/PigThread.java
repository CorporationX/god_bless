package school.faang.task_61058;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final Material material;

    public void buildHouse(int delay) {
        System.out.printf("%s is building a house out of %s\n", getPigName(), getMaterial().name());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.out.println("This thread has been aboarted");
            Thread.currentThread().interrupt();
            throw new RuntimeException();
        }
        System.out.printf("%s built a house out of %s\n", getPigName(), getMaterial().name());
    }
}
