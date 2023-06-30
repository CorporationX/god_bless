package faang.school.godbless.skynet;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Robot {
    private String name;
    private String target;

    public synchronized void attack() {
        System.out.println(getName() + " жестко замочил " + getTarget());
    }
}