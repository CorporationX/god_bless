package faang.school.godbless.lor;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Character {
    List<Item> inventory = new ArrayList<>();
}
