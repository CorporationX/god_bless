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
            Image filteredImage1 = filter1.apply(image);
            Image filteredImage2 = filter2.apply(filteredImage1);
            String combinedDescription = filteredImage1.getDescription().trim() + " + " +
                    filteredImage2.getDescription().substring(filteredImage2.getDescription().indexOf(" ") + 1);
            return new Image(filteredImage2.getName(), combinedDescription);
        };
    }
}
