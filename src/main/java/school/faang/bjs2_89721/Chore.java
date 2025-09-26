package school.faang.bjs2_89721;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Chore implements Runnable {

    private String name;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is performing chore: " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
