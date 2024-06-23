package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_19_instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image originalImage, Function<Image, Image> imageFilter) {
        return imageFilter.apply(originalImage);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {

        return image -> {
            Image imageWithOneFilter = firstFilter.apply(image);
            Image imageWithTwoFilter = secondFilter.apply(imageWithOneFilter);
            return new Image(imageWithTwoFilter.name(), "%s; %s".formatted(imageWithOneFilter.description(), imageWithTwoFilter.description()));
        };
    }
}
