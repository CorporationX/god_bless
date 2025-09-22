package school.faang.instagram_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

/**
 * Проект: god_bless
 * Класс Image
 * Автор: Vital
 * Дата: 22.09.2025
 */

@AllArgsConstructor
@Getter
public class Image {
    @NonNull
    private final String name;
    private final String description;
}
