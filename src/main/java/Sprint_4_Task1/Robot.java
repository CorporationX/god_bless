package Sprint_4_Task1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot {
    private final String target;

    public void attack() {
        synchronized (target) {
            System.out.println(Thread.currentThread().getName() + " attack " + target);
        }

    }

}
