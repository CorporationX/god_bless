package BJS2_9753;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image != null) return filter.apply(image);
        else return null;
    }
    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return image -> filter1.apply(filter2.apply(image));
    }
}