package school.faang.module1.bjs2_80463;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filterImage) {
        return filterImage.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst,
                                                 Function<Image, Image> filterSecond) {
        return image -> filterFirst.andThen(filterSecond).apply(image);
    }
}