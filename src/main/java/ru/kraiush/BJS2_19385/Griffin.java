package ru.kraiush.BJS2_19385;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Griffin extends Creature {

    private String type= "griffin";
    private Integer level;
    private Integer attack;
    private Integer defense;
    private Integer rate;

    @Override
    void getDamage() {

    }
}
