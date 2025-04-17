package school.faang.stream2.lotrrpg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
