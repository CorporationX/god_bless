package instagramFilters;

import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public class FilterProcessor {
    public Image applyFilter(Image imageIn, Function<Image, Image> filter) {
        Image filteredImage = filter.apply(imageIn);

        return filteredImage;
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter, Function<Image, Image> secondFilter) {
        Function<Image, Image> combinedFilter = (image) -> {
            image = firstFilter.apply(image);
            image = secondFilter.apply(image);
            return image;
        };

        return combinedFilter;
    }
}
