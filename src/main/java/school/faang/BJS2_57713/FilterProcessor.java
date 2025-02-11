package school.faang.BJS2_57713;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function filter) {
        return (Image) filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function filterOne, Function filterTwo) {
        return filterOne.andThen(filterTwo);
    }

}
