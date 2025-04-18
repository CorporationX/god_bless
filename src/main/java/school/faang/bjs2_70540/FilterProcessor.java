package school.faang.bjs2_70540;

import java.util.function.UnaryOperator;

class FilterProcessor {

    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public Image combineFilters(Image image, UnaryOperator<Image> filter1, UnaryOperator<Image> filter2) {
        return filter1.andThen(filter2).apply(image);
    }
}
