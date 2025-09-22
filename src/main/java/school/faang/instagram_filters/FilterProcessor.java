package school.faang.instagram_filters;

import lombok.NonNull;

import java.util.function.Function;

/**
 * Проект: god_bless
 * Класс FilterProcessor
 * Автор: Vital
 * Дата: 22.09.2025
 */

public class FilterProcessor {
    public Image applyFilter(@NonNull Image image, @NonNull Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(@NonNull Function<Image, Image> firstParam,
                                                 @NonNull Function<Image, Image> secondParam) {
        return firstParam.andThen(secondParam);
    }
}