package school.faang.lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

/**
 * Проект: god_bless
 * Класс Character
 * Автор: Vital
 * Дата: 22.09.2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Character {
    @NonNull private String name;
    private List<Item> inventory;
}