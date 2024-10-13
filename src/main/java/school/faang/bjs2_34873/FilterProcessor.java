package school.faang.bjs2_34873;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
       return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> image1, Function<Image, Image> image2) {
        return image1.andThen(image2);
    }
}
