package faang.school.godbless.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
class Character {
    private String name;
    private List<Item> inventory;
}
