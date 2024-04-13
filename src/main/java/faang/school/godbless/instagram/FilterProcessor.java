package faang.school.godbless.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> toNewFormat) {
        return toNewFormat.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return (image -> filter1.apply(filter2.apply(image)));
    }

}
