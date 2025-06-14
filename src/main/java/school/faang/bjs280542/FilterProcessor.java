package school.faang.bjs280542;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FilterProcessor {
    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(UnaryOperator<Image> filtImag1, UnaryOperator<Image> filtImag2) {
        return image -> filtImag1.compose(filtImag2).apply(image);
    }
}
