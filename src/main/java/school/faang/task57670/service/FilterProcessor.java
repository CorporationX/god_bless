package school.faang.task57670.service;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image img, Function<Image, Image> filter) {
        return filter.apply(img);
    }

    public Function<Image, Image> combinedFilters(Function<Image, Image> img1, Function<Image, Image> img2) {
        return img1.andThen(img2);
    }
}
