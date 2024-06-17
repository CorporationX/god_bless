package faang.school.godbless.lambdas8;

import java.util.ArrayList;
import java.util.List;

public record Character(String name, List<Item> inventory) {
    public Character(String name) {
        this(name, new ArrayList<>());
    }
}
