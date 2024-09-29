package ru.kraiush.threads.BJS2_23511;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
public class Character {

    private String name;
    private String race;
    private int power;

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
