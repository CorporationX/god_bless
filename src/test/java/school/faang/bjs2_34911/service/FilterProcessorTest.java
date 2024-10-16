package school.faang.bjs2_34911.service;

import org.junit.jupiter.api.Test;
import school.faang.bjs2_34911.constants.ErrMessagesValidate;
import school.faang.bjs2_34911.model.Filter;
import school.faang.bjs2_34911.model.FilterDescription;
import school.faang.bjs2_34911.model.Image;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    private final FilterProcessor filterProcessor = new FilterProcessor();

    @Test
    void applyFilter() {
        IllegalArgumentException illegalArgumentExceptionImageNull = assertThrows(IllegalArgumentException.class,
                () -> filterProcessor.applyFilter(null, Filter.BLUR));
        assertEquals(ErrMessagesValidate.IMAGE_IS_NULL, illegalArgumentExceptionImageNull.getMessage());

        Image imageTestException = new Image("Test", "Test");
        IllegalArgumentException illegalArgumentExceptionFilterNull = assertThrows(IllegalArgumentException.class,
                () -> filterProcessor.applyFilter(imageTestException, null));
        assertEquals(ErrMessagesValidate.FILTER_IS_NULL, illegalArgumentExceptionFilterNull.getMessage());

        Image correctResultImage = new Image("Test", "Test" + FilterDescription.BLUR + FilterDescription.CONTRAST);
        Image testImage = new Image("Test", "Test");

        Image imageMiddleResult = filterProcessor.applyFilter(testImage, Filter.BLUR);
        Image imageResult = filterProcessor.applyFilter(imageMiddleResult, Filter.CONTRAST);
        assertEquals(correctResultImage, imageResult);
    }

    @Test
    void combineFilters() {
        IllegalArgumentException illegalArgumentExceptionFilterOneNull = assertThrows(IllegalArgumentException.class,
                () -> filterProcessor.combineFilters(null, Filter.BLUR));
        assertEquals(ErrMessagesValidate.FILTER_IS_NULL, illegalArgumentExceptionFilterOneNull.getMessage());

        IllegalArgumentException illegalArgumentExceptionFilterTwoNull = assertThrows(IllegalArgumentException.class,
                () -> filterProcessor.combineFilters(Filter.BLUR, null));
        assertEquals(ErrMessagesValidate.FILTER_IS_NULL, illegalArgumentExceptionFilterTwoNull.getMessage());

        Function<Image, Image> oneFilter = Filter.BLUR;
        Function<Image, Image> twoFilter = Filter.BRIGHTNESS;

        Image correctResultImage = new Image("Test", "Test" + FilterDescription.BLUR + FilterDescription.BRIGHTNESS);
        Image testImage = new Image("Test", "Test");

        Function<Image, Image> blurBrightnessFilter = filterProcessor.combineFilters(oneFilter, twoFilter);
        Image imageResult = filterProcessor.applyFilter(testImage, blurBrightnessFilter);
        assertEquals(correctResultImage, imageResult);
    }
}