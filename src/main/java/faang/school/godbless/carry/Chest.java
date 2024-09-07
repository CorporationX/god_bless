package faang.school.godbless.carry;

import lombok.Getter;

import java.util.List;

@Getter
public class Chest {

    private final List<Item> items = List.of(
            new Item("Меч", 1),
            new Item("Пестик", 5),
            new Item("Гранатомет", 30));
}
