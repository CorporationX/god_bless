package faang.school.godbless.BJS2_809;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private List<Item> inventory = new ArrayList<>();
    private String name;

    public Character(String name) {
        this.name = name;
    }
}