package faang.school.godbless.normalgame;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {

    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println(String.format("%s starts building house with %s", getPigName(), getMaterial()));
        sleep();
        System.out.println(String.format("%s ends building house with %s", getPigName(), getMaterial()));
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
