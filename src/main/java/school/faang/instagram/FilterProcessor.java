package school.faang.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        checkImage(image);
        checkFilter(filter);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image,
            Image> filterA, Function<Image, Image> filterB) {
        checkFilter(filterA);
        checkFilter(filterB);
        return filterA.andThen(filterB);
    }

    private void checkImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Не может быть пустым");
        }
    }

    private void checkFilter(Function<Image, Image> filter) {
        if (filter == null) {
            throw new IllegalArgumentException("Фильтр не может быть пустым");
        }
    }
}