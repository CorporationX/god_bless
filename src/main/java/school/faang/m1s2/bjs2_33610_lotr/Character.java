package school.faang.m1s2.bjs2_33610_lotr;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Character {
    private final String name;
    private final Set<Item> inventory = new HashSet<>();
}
