package school.faang.task57454.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private String name;
    private List<Item> inventory;

    public Character(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }
}


