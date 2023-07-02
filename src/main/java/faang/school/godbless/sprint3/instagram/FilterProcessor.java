package faang.school.godbless.sprint3.instagram;

import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor
public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filter) {
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filter1, Function<Image, Image> filter2) {
        return filter2.compose(filter1);
    }
}
