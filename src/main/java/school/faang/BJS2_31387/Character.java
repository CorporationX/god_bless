package school.faang.BJS2_31387;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int sila;
    private int lovkost;
    private int intellect;
    private int zdorovye = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int sila, int lovkost, int intellect) {
        this.name = name;
        this.sila = sila;
        this.lovkost = lovkost;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
