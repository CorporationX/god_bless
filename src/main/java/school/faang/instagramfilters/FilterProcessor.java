package school.faang.instagramfilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Изображение не может быть null");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр не может быть null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        if (firstFilter == null || secondFilter == null) {
            throw new IllegalArgumentException("Фильтр не может быть null");
        }
        return firstFilter.andThen(secondFilter);
    }
}
