package faang.school.godbless.lambda.filtersOfInstagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("Объект image равен null!");
        }
        if (filter == null) {
            throw new IllegalArgumentException("Объект filter равен null!");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst, Function<Image, Image> filterSecond) {
        if (filterFirst == null || filterSecond == null){
            throw new IllegalArgumentException("Один из объектов фильтров равен null!");
        }
        return filterFirst.andThen(filterSecond);
    }
}
