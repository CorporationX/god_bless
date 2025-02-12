package school.faang.lord_of_rings;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Character {

    private final @NonNull String name;
    private final List<Item> inventory = new ArrayList<>();
}
