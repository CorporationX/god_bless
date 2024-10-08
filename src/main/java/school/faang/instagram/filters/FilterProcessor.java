package school.faang.instagram.filters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null) {
            throw new IllegalArgumentException("нельзя применить фильтр, когда image null");
        }
        if (filter == null) {
            return image;
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1,
                                                 Function<Image, Image> filter2) {
        return image -> {
            Image combined = image;
            if (filter1 != null) {
                combined = filter1.apply(image);
            }
            if (filter2 != null) {
                combined = filter2.apply(combined);
            }
            return combined;
        };
    }
}
