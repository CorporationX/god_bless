package school.faang.instagram_filters.BJS2_57744;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class FilterProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilterProcessor.class);

    public Image applyFilter(@NonNull Image originalImage, @NonNull Function<Image, Image> function) {
        Image result = function.apply(originalImage);

        validateObjectForNull(result == null, "Result is null");

        return result;
    }

    public Function<Image, Image> combineFilters(
            @NonNull Function<Image, Image> firstFunction, @NonNull Function<Image, Image> secondFunction) {
        Function<Image, Image> combinedFunction = firstFunction.andThen(secondFunction);

        validateObjectForNull(combinedFunction == null, "Function is null");

        return combinedFunction;
    }

    private static void validateObjectForNull(boolean isNull, String errorMessage) {
        if (isNull) {
            LOGGER.error(errorMessage);
            throw new NullPointerException(errorMessage);
        }
    }

}
