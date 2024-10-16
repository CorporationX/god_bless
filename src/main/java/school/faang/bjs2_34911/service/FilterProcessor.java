package school.faang.bjs2_34911.service;

import school.faang.bjs2_34911.model.Image;

import java.util.function.Function;

public class FilterProcessor {
    private final ValidatorFilterProcessor validator = new ValidatorFilterProcessor();

    public Image applyFilter(Image image, Function<Image, Image> filter) {
        validator.validateApplyFilter(image, filter);
        return filter.apply(image);
    }

    public Function<Image, Image> combineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        validator.validateCombineFilters(filterOne, filterTwo);
        return image -> {
            Image imageAfterOneFilter = filterOne.apply(image);
            return filterTwo.apply(imageAfterOneFilter);
        };
    }
}
