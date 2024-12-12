package derschrank.sprint02.task03.bjstwo_46685;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FilterProcessor {
    public Image applyFilter(Image img, UnaryOperator<Image> filter) {
        return filter.apply(img);
    }

    public UnaryOperator<Image> combineFilters(UnaryOperator<Image> first, UnaryOperator<Image> second) {
        return (Image img) -> second.apply(first.apply(img));
    }
}