package faang.school.godbless.carry;

import lombok.Getter;

import java.util.List;

@Getter
public class Shop {

    private final List<Item> items = List.of(
            new Item("Лук", 3),
            new Item("Пушка", 50),
            new Item("Граната", 15));
}
