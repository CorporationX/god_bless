package faang.school.godbless.modul2.instafilters;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || filter == null) {
            throw new NullPointerException("Image and filter can't be null");
        }
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null || filter2 == null) {
            throw new NullPointerException("Filter can't be null");
        }
        return (image) -> {
            var filteredImage = filter2.apply(filter1.apply(image));
            var combinedDescription = filteredImage.getDescription().trim() + " + " +
                    filteredImage.getDescription().substring(filteredImage.getDescription().indexOf(" ") + 1);
            return new Image(filteredImage.getName(), combinedDescription);
        };
    }
}
