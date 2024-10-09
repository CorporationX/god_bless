package school.faang.BJS2_34837_InstagramFilters;

import java.util.function.Function;

public class ImageProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        validateImage(image);
        validateFunction(filter, "Invalid image filter!");
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        validateFunction(firstFilter, "Invalid first image filter!");
        validateFunction(secondFilter, "Invalid second image filter!");
        return image -> secondFilter.apply(firstFilter.apply(image));
    }

    private void validateFunction(Function<?, ?> function, String message) {
        if (function == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateImage(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Image can't be null!");
        }
    }
}
