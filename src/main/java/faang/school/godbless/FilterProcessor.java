package faang.school.godbless;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return (image) -> new Image("Combined by: |" + firstFilter.apply(image).getName() + "| and |" + secondFilter.apply(image).getName() + "|",
                "|" + firstFilter.apply(image).getDescription() + " + " + secondFilter.apply(image).getDescription() + "+");
    }
}
