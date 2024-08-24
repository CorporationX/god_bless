package faang.school.godbless.Poor_things;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        try {
            Thread.currentThread().getName();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
