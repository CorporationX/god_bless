package faang.school.godbless.BJS2_10938;

import lombok.Getter;

@Getter
public abstract class Soldier {
    protected int power;
    protected String group;

    public Soldier(int power, String group) {
        this.power = power;
        this.group = group;
    }
}
