package school.faang.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Проект: god_bless
 * Класс Item
 * Автор: Vital
 * Дата: 22.09.2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @NonNull private String name;
    private int value;
}
