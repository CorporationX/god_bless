package school.faang.bjs270086;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@Getter
@RequiredArgsConstructor
public class Character {
    private final String name;
    private List<Item> inventory = new ArrayList<>();
}
