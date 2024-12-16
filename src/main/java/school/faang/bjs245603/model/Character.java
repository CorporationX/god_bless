package school.faang.bjs245603.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ToString
@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
