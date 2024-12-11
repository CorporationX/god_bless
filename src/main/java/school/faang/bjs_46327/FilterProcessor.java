package school.faang.bjs_46327;

import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor
public class FilterProcessor {

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        if (image == null || image.getName() == null || image.getName().isEmpty() || image.getDescription() == null) {
            throw new IllegalArgumentException("image is null");
        }
        return filter.apply(image);
    }

    public Function<Image,Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        if (filter1 == null || filter2 == null) {
            throw new IllegalArgumentException("filter is null");
        }
        return filter1.andThen(filter2);
    }
}
