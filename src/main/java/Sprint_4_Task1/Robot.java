package Sprint_4_Task1;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Robot{
    private String target;

    public synchronized void attack() {
        System.out.println(Thread.currentThread().getName() + " attack " + target);
    }

}
