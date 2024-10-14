package school.faang.bjs2_34911.service;

import school.faang.bjs2_34911.constants.ErrMessagesValidate;
import school.faang.bjs2_34911.model.Image;

import java.util.function.Function;

public class ValidatorFilterProcessor {
    private void validateNotNull(Object object, String errMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public void validateApplyFilter(Image image, Function<Image, Image> filter) {
        validateNotNull(image, ErrMessagesValidate.IMAGE_IS_NULL);
        validateNotNull(filter, ErrMessagesValidate.FILTER_IS_NULL);
    }

    public void validateCombineFilters(Function<Image, Image> filterOne, Function<Image, Image> filterTwo) {
        validateNotNull(filterOne, ErrMessagesValidate.FILTER_IS_NULL);
        validateNotNull(filterTwo, ErrMessagesValidate.FILTER_IS_NULL);
    }
}
