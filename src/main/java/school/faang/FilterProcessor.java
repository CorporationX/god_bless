package school.faang;

import java.util.function.Function;

class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        Image filteredImage = filter.apply(image);
        return filteredImage;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return image -> filter2.apply(filter1.apply(image));
    }
}