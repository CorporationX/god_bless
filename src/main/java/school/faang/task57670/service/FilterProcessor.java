package school.faang.task57670.service;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image img, Function<Image, Image> filter) {
        return filter.apply(img);
    }
}
