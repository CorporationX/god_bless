package school.faang.task_46233;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (StringUtils.isBlank(image.name()) || StringUtils.isBlank(image.description())) {
            throw new IllegalArgumentException("Image is not in good shape!");
        }
        image = filter.apply(image);
        return image;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst,
                                                 Function<Image, Image> filterSecond) {
        return image -> filterSecond.apply(filterFirst.apply(image));
    }
}
