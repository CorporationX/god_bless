package school.faang.sprint_2.task_bjs246345;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.UnaryOperator;

public class FilterProcessor {
    private final Logger log = LoggerFactory.getLogger(FilterProcessor.class);

    public Image applyFilter(Image image, UnaryOperator<Image> filter) {
        checkValidInput("applyFilter", image, filter);
        return filter.apply(image);
    }

    public UnaryOperator<Image> combineFilters(
            UnaryOperator<Image> firstFilter, UnaryOperator<Image> secondFilter
    ) {
        checkValidInput("combineFilters", firstFilter, secondFilter);
        return image -> secondFilter.apply(firstFilter.apply(image));
    }

    private <T, U> void checkValidInput(String methodName, T first, U second) {
        if (first == null || second == null) {
            log.warn("get null input in method {}", methodName);
            throw new IllegalArgumentException("Input in method " + methodName + " cannot be null");
        }
    }
}
