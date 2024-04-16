package faang.school.godbless.BJS2_5345;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}