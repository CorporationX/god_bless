package faang.school.godbless.InstagramFilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image != null && filter != null) {
            return filter.apply(image);
        } else {
            System.out.println("Image or filter is null :{ ");
            return image;
        }
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 != null && filter2 != null) {
            return filter1.andThen(filter2);
        } else {
            System.out.println("Filter is null :{ ");
            return Function.identity();
        }
    }
}
