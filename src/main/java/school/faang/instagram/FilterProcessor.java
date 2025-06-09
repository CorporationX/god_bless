package school.faang.instagram;

import java.util.function.UnaryOperator;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public class FilterProcessor {

    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(UnaryOperator<Image> filter1, UnaryOperator<Image> filter2) {
        return image -> filter1.compose(filter2).apply(image);
    }
}
