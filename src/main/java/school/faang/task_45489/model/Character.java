package school.faang.task_45489.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private final String name;
}
