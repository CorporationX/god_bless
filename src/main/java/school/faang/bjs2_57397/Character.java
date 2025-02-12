package school.faang.bjs2_57397;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Character {
    private final String name;
    private final Set<Item> items = new HashSet<>();
}
