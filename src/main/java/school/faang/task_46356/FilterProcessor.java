package school.faang.task_46356;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }



    public Function<Image, Image> combineFilters(Function<Image, Image> grayscaleFilter, Function<Image, Image> sepiaFilter) {
        return grayscaleFilter.andThen(sepiaFilter);
    }
}


