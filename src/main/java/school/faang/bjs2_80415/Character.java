package school.faang.bjs2_80415;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Character {
    private String name;
    private final List<Item> inventory = new ArrayList<>();
}
