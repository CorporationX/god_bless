package ru.kraiush.threads.BJS2_23817;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Knight {

    String name;
    List<Trial> listTrials;

    public Knight(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Knight{ name = " + name + "}";
    }
}
