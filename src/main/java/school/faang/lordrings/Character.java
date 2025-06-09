package school.faang.lordrings;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Персонаж
 *
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
@Data
public class Character {

    /**
     * Имя персонажа
     */
    private final String name;

    /**
     * Список предметов, которые персонаж носит с собой
     */
    private final Set<Item> inventory = new HashSet<>();
}
