package faang.school.godbless.sprint_3.lord_of_the_rings_RPG;


import lombok.Getter;

@Getter

public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
