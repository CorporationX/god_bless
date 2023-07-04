package faang.school.godbless.kxnvg.skynet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {

    private String name;
    private String target;

    public void attack() {
        synchronized (target) {
            System.out.println("Робот " + name + " атаковал цель: " + target);
        }
    }
}
