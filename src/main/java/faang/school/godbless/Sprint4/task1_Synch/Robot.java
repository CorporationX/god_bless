package faang.school.godbless.Sprint4.task1_Synch;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String name;
    private String target;

    public synchronized void attack() {
        System.out.println("Robot " + name + " attacks " + target);
    }
}
