package faang.school.godbless.UpgradingAlchemy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Potion {
    private String name;
    private List<String> requiredIngredients;
}