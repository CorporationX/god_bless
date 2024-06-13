package faang.school.godbless.lotr;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    @NonNull private List<Item> inventory = new ArrayList<>();
    private final String name;
}
