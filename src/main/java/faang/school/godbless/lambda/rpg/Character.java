package faang.school.godbless.lambda.rpg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Character {
    @NonNull
    private String name;
    private final List<Item> inventory = new ArrayList<>();
}
