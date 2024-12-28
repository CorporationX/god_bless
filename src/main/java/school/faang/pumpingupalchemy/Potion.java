package school.faang.pumpingupalchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Potion {

    private final String name;
    private final int requiredIngredients;
    private final List<Potion> potions = new ArrayList<>();
}
