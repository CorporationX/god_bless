package school.faang.bjs2_57397;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Getter
public class Character {
    private final String name;
    private final List<Item> items = new ArrayList<>();
}
