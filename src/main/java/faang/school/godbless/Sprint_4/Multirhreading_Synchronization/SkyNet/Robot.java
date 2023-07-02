package faang.school.godbless.Sprint_4.Multirhreading_Synchronization.SkyNet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private int target;

    public synchronized void attack() {
        System.out.printf("Now i'm attacking %d\n", target);
    }
}
