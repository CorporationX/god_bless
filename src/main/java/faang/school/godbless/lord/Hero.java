package faang.school.godbless.lord;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
public class Hero {
    private String name;
    private Set<Item> inventory;

    public Hero(String name) {
        this.name = name;
        inventory = new HashSet<>();
    }
}
