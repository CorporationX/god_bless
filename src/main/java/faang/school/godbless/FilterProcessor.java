package faang.school.godbless;

import java.util.function.Function;

public class FilterProcessor {
    public Image applyFilter(Image image, Function<Image, Image> filterImage){
        return filterImage.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> firstFilter,
                                                 Function<Image, Image> secondFilter){
        return new Function<Image, Image>() {
            @Override
            public Image apply(Image image) {
                return firstFilter.apply(secondFilter.apply(image));
            }
        };
    }
}
