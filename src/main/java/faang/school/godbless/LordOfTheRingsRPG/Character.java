package faang.school.godbless.LordOfTheRingsRPG;

import lombok.Getter;

import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
    }
}
