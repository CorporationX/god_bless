package bjs2_91911;

import java.util.function.Function;

public class FilterProcessor {

    // Применяем фильтр
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    // Объединяем два фильтра в один
    public Function<Image, Image> combineFilters(Function<Image, Image> first, Function<Image, Image> second) {
        return first.andThen(second);
    }
}