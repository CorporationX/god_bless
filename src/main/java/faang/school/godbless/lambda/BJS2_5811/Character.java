package faang.school.godbless.lambda.BJS2_5811;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Character {
    private String name;
    private final List<Item> inventory = new ArrayList<>();
}
