package school.faang.instagram_filters.BJS2_57744;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class FilterProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterProcessor.class);

    public Image applyFilter(Image originalImage, Function<Image, Image> function) {
        validateObjectForNull(originalImage == null, "Original image is null");
        validateObjectForNull(function == null, "Function is null");

        Image result = function.apply(originalImage);

        validateObjectForNull(result == null, "Result is null");

        return result;
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFunction, Function<Image, Image> secondFunction) {

        validateObjectForNull(firstFunction == null, "Function is null");
        validateObjectForNull(secondFunction == null, "Function is null");

        Function<Image, Image> combinedFunction = firstFunction.andThen(secondFunction);

        validateObjectForNull(combinedFunction == null, "Function is null");

        return combinedFunction;
    }

    private static void validateObjectForNull(boolean originalImage, String errorMessage) {
        if (originalImage) {
            LOGGER.error(errorMessage);
            throw new NullPointerException(errorMessage);
        }
    }

}
