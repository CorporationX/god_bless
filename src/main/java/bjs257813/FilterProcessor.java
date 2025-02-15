package bjs257813;

import lombok.Getter;

import java.util.function.Function;

@Getter
public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> converter) {
        return converter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterBefore,
                                                 Function<Image, Image> filterAfter) {
        return filterBefore.andThen(filterAfter);
    }
}
