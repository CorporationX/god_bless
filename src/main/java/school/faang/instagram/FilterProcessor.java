package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Изображение отсутствует");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterA, Function<Image, Image> filterB) {
        return filterA.andThen(filterB);
    }
}