package school.faang.task_57622;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image originalImage, Function<Image, Image> filter) {
        if (originalImage == null) {
            throw new IllegalArgumentException("Изображение отсутствует!");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр отсутствует!");
        }
        return filter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst,
                                                 Function<Image, Image> filterSecond) {
        if (filterFirst == null || filterSecond == null) {
            throw new IllegalArgumentException("Фильтр отсутствует!");
        }
        return filterFirst.andThen(filterSecond);
    }
}
