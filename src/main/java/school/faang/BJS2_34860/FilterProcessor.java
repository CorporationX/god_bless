package school.faang.BJS2_34860;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterWhite, Function<Image, Image> filterBlack) {
        return (image) -> filterWhite.apply(filterBlack.apply(image));
    }
}
