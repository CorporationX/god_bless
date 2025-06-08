package school.faang.bjs2_80403;

import java.util.function.Function;

public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filterImage) {
        return filterImage.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterFirst,
                                                 Function<Image, Image> filterSecond) {
        return image -> {
            Image filteredImage = filterFirst.apply(image);
            filteredImage = filterSecond.apply(filteredImage);
            return filteredImage;
        };
    }
}
