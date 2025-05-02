package school.faang.magic;

import lombok.Getter;

@Getter
abstract class Warriors {
    protected int power;

    public Warriors(int power) {
        this.power = power;
    }
}