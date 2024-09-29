package ru.kraiush.BJS2_19385;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Creature {

    private String type;
    private Integer level;
    private Integer attack;
    private Integer defense;
    private Integer rate;

    abstract  void getDamage();
}
