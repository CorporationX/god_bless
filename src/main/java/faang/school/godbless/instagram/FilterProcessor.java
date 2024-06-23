package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filters) {
        try {
            return filters.apply(image);
        } catch (Exception e) {
            throw new RuntimeException("The image is invalid", e);
        }
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter1.andThen(filter2);

    }

}
