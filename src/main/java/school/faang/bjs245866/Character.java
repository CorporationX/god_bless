package school.faang.bjs245866;


import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Character {

    @NonNull
    private String name;
    private final List<Item> inventory = new ArrayList<>();
}
