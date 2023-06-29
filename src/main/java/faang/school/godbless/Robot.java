package faang.school.godbless;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Robot {
    private String target;

    public void attack() {
        synchronized (target) {
            System.out.println(target + "is attacked");
        }
    }
}
