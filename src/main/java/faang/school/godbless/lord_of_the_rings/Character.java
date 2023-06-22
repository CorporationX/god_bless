package faang.school.godbless.lord_of_the_rings;

import lombok.Getter;

import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> items;

    public Character(String name){
        this.name = name;
    }
}
