package school.faang.bjs2_87284;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(includeFieldNames = true)
@RequiredArgsConstructor
public class Character {
    private final String name;
    private final List<Item> inventory = new ArrayList<>();
}
