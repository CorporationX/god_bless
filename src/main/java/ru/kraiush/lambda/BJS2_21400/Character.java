package ru.kraiush.lambda.BJS2_21400;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Character {

    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }
}
