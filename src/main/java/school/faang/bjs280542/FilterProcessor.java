package school.faang.bjs280542;

import java.util.function.UnaryOperator;

public class FilterProcessor {
    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(UnaryOperator<Image> firstFilter, UnaryOperator<Image> secondFilter) {
        var filter = (UnaryOperator<Image>) firstFilter.andThen(secondFilter);
        return filter;
    }
}
