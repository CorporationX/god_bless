package faang.school.godbless.InstagramFilter;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        return (image) -> new Image(firstFilter.apply(image).getName() + secondFilter.apply(image).getName().replace(image.getName(), ""),
                firstFilter.apply(image).getDescription() + " + " + secondFilter.apply(image).getDescription().replace("Фильтр: ", ""));
    }
}
