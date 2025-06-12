package school.faang.instafilter;

import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> imageFilter) {
        return imageFilter.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> applyFilter,
            Function<Image, Image> baseFilter
    ) {
        return baseFilter.compose(applyFilter);
    }

}
