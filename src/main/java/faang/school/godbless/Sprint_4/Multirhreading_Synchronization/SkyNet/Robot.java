package faang.school.godbless.Sprint_4.Multirhreading_Synchronization.SkyNet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private final int target;

    public void attack() {
        synchronized ((Object) target) {
            System.out.printf("Now i'm attacking %d\n", target);
        }
    }
}