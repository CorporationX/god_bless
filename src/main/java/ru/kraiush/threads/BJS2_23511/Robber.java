package ru.kraiush.threads.BJS2_23511;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robber extends Character {

    private String name;
    private String race;
    private int power;

    public Robber(String name, String race, int power) {
        super(name, race, power);
        this.name= name;
        this.race= race;
        this.power= power;
    }
}
