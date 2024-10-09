package instagram.filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Загрузите изображение");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Примените фильтр");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne,
                                                 Function<Image, Image> filterTwo) {
        if (filterOne == null || filterTwo == null) {
            throw new IllegalArgumentException("Примените два фильтра");
        }
        return filterOne.andThen(filterTwo);
    }
}
