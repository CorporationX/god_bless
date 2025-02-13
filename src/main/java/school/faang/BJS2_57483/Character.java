package school.faang.BJS2_57483;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class Character {
    private String name;
    private final List<Item> inventory = new ArrayList<>();
}
