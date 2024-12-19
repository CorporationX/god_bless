package school.faang.bjs245600;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Character {
    private final String name;
    List<Item> inventory = new ArrayList<>();
}