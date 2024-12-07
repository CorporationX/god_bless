package school.faang.task_46220;

import school.faang.task_46220.model.Image;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> firstFilter,
            Function<Image, Image> secondFilter) {
        return firstFilter.andThen(secondFilter);
    }
}
