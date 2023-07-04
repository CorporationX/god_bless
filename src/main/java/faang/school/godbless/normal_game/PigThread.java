package faang.school.godbless.normal_game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    @NonNull
    private String pigName;
    @NonNull
    private String material;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " built a house from " + getMaterial() + "! " + Thread.currentThread().getName());
    }
}
