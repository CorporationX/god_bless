package filtersByInstagram;

import lombok.ToString;

import java.util.function.Function;

@ToString
public class FilterProcessor {

    public static Image applyFilter(Image image, Function<Image, Image> filterName) {
            image = filterName.apply(image);
        return image;
    }

    public static Function<Image, Image> combineFilters(Function<Image, Image> filer1, Function<Image, Image> filter2) {
        Function<Image, Image> filterCombine = filer1.andThen(filter2);
        return filterCombine;
    }


}

