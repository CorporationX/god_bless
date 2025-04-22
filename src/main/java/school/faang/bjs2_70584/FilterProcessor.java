package school.faang.bjs2_70584;

import java.util.function.UnaryOperator;

public class FilterProcessor {

    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(UnaryOperator<Image> firstFilter, UnaryOperator<Image> secondFilter) {
        return image -> applyFilter(
                applyFilter(image, firstFilter),
                secondFilter
        );
    }
}
