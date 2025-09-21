package school.faang.bjs2_91910;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            throw new IllegalArgumentException("Изображение и фильтр не могут быть пустыми");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter
    ) {
        if (firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("Фильтры не могут быть пустыми");
        }

        return firstFilter.andThen(secondFilter);
    }
}
