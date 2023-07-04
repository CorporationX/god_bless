package faang.school.godbless.alchimy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
public class Potion {
    private String name;
    private int requiredIngredients;
}
