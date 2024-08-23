package faang.school.godbless.solger;

import lombok.Data;

@Data
public abstract class Solger {
    int power;

    public Solger(int power) {
        this.power = power;
    }
}
