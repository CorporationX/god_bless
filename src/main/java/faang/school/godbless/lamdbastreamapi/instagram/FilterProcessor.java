package faang.school.godbless.lamdbastreamapi.instagram;

import java.util.function.Function;

public class FilterProcessor {

    public FilterProcessor() {
    }

    public Image applyFilter(Image image, Function<Image, Image> functionImage) {
        return functionImage.apply(image);
    }

    public Function<Image, Image> combineFilters(
            Function<Image, Image> functionLeft,
            Function<Image, Image> functionRight
    ) {
        return functionLeft.andThen(functionRight);
    }

}
