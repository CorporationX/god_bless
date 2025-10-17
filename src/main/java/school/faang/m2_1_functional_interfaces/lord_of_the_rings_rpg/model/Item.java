package school.faang.m2_1_functional_interfaces.lord_of_the_rings_rpg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    private final String name;
    private final int value;
}
