package school.faang.alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;

}
