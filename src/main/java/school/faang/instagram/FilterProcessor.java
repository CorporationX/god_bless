package school.faang.instagram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class FilterProcessor {
    private static final Logger logger = LoggerFactory.getLogger(FilterProcessor.class);

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        checkValidArgument(image, "Image");
        checkValidArgument(filter, "Filter");
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        checkValidArgument(firstFilter, "First filter");
        checkValidArgument(secondFilter, "Second filter");
        return firstFilter.andThen(secondFilter);
    }

    private <T> void checkValidArgument(T argument, String argumentName) {
        if (argument == null) {
            logger.error("Validation failed: argument '{}' is null! Location: {}:{}",
                    argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            throw new IllegalArgumentException("The " + argumentName + " cannot be null.");
        }
        if (argument.getClass() == String.class && ((String) argument).isBlank()) {
            logger.error("Validation failed: argument '{}' is blank! Location: {}:{}",
                    argumentName,
                    Thread.currentThread().getStackTrace()[2].getFileName(),
                    Thread.currentThread().getStackTrace()[2].getLineNumber());
            throw new IllegalArgumentException("The " + argumentName + " cannot be blank.");
        }
    }
}
