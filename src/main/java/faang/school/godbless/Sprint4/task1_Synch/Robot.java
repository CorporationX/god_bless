package faang.school.godbless.Sprint4.task1_Synch;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class Robot {
    private String name;
    private Robot target;

    public  void attack() {
        synchronized (target) {
            System.out.println("Robot " + name + " attacks " + target.name);
        }
    }
}
