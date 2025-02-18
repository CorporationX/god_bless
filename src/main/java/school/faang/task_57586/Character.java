package school.faang.task_57586;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    @NonNull
    private String name;
}
