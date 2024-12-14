package school.faang.lordof_therings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
