package faang.school.godbless.lambdas.task_8.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Character {
    private final List<Item> inventory = new ArrayList<>();
    private final String name;
}