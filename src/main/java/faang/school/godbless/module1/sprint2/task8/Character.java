package faang.school.godbless.module1.sprint2.task8;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    List<Item> items;

    public Character(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

}
