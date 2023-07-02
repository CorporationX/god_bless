package faang.school.godbless.threads.heroes;

import lombok.Getter;

@Getter
public abstract class Hero {
    private int power;

    public Hero(int power) {
        this.power = power;
    }
}
