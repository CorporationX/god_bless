package pumping_alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private int requiredIngredients;
}
