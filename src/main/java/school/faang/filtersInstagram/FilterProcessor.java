package school.faang.filtersInstagram;

import lombok.NonNull;

import java.util.function.Function;

@NonNull
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> grayscaleFilter) {
        return grayscaleFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}
