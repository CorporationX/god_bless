package school.faang.bjs2_59715;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Character {

    private String name;
    private final List<Item> inventory = new ArrayList<>();

}
