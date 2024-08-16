package lotr;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Character {
    @NonNull
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
