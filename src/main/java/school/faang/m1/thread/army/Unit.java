package school.faang.m1.thread.army;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Unit {
    private int power;

    protected int getPower() {
        return power;
    }
}
