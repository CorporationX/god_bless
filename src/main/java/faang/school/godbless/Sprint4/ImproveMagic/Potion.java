package faang.school.godbless.Sprint4.ImproveMagic;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Potion {
    private String name;
    private int requiredIngredients;
    private long timeToSearch;
}
