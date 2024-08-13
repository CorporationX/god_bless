package faang.school.godbless.BJS2_21873;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function filter) {
        return (Image) filter.apply(image);
    }

    public Function combineFilters(Function filter1, Function filter2) {
        return image -> filter2.apply(filter1.apply(image));
    }
}
