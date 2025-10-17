package school.faang.pumping_alchemy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * Проект: god_bless
 * Класс Potion
 * Автор: Vital
 */

@Data
@AllArgsConstructor
public class Potion {
    @NonNull
    private String name;

    private int requiredIngredients;
}