package faang.school.godbless.sprint3.Lord_Of_The_Rings_RPG;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

@Getter
@ToString
public class Character {
    private String name;
    private List<Item> inventory = new LinkedList<>();

    public Character(String name) {
        this.name = name;
    }

    public void setInventory(Object tmp, Consumer consumer) {
        consumer.accept(tmp);
    }
}
