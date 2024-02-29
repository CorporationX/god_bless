package faang.school.godbless.alchemy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Potion {
    private String name;
    private AtomicInteger requiredIngridients;
}
