package school.faang.functional_interfaces_lambda_2_1.bjs2_70540;

import java.util.function.UnaryOperator;

class FilterProcessor {

    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public Image combineFilters(Image image, UnaryOperator<Image> filter1, UnaryOperator<Image> filter2) {
        return filter1.andThen(filter2).apply(image);
    }
}
