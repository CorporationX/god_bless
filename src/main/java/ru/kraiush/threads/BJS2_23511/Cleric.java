package ru.kraiush.threads.BJS2_23511;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Cleric extends Character {

    private String name;
    private String race;
    private int power;

    public Cleric(String name, String race, int power) {
        super(name, race, power);
        this.name= name;
        this.race= race;
        this.power= power;
    }
}
