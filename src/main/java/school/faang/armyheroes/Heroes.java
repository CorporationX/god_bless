package school.faang.armyheroes;

import lombok.Getter;

@Getter
public abstract class Heroes {
    private String name;
    private int power;

    public Heroes(String name, int power) {
        this.name = name;
        this.power = power;
    }
}
