package school.faang.task_45492;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Character {
    private String name;
    private List<Item> itemList = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }
}
