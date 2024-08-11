package faang.school.godbless.functionalInterfaces.insta;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    FilterProcessor filterProcessor = new FilterProcessor();

    @Test
    void testApplyFilterValidParamsAppliesFilter() {
        //given
        var originalImage = new Image("image", ".png", "Yet another selfie");

        Function<Image, Image> inverseFilter = (image) -> filterProcessor.filtering(image,
                "_inverse",
                " with inverse filter on");


        var expectedResult = new Image("image_inverse", ".png", "Yet another selfie with inverse filter on");

        //when
        var actualResult = filterProcessor.applyFilter(originalImage, inverseFilter);

        //then
        assertNotNull(actualResult);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void testApplyFilterInvalidParamsThrowsException() {
        //given
        var validImage = new Image("image", ".png", "Yet another selfie");
        var imageWithBlankName = new Image("", ".png", "Yet another selfie");
        var imageWithNullName = new Image(null, ".png", "Yet another selfie");
        var imageWithBlankExtension = new Image("image", "", "Yet another selfie");
        var imageWithNullExtension = new Image("image", null, "Yet another selfie");

        Function<Image, Image> validFilter = (image) -> filterProcessor.filtering(image,
                "_inverse",
                " with inverse filter on");


        var nullImageExpectedMessage = "Original image must be non-null valued!";
        var invalidNameOrExtensionExpectedMessage = "Original image cannot have null or blank file name and extension!";
        var nullFilterExpectedMessage = "Filter must be non-null valued!";


        //when
        Exception nullImageResult = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.applyFilter(null, validFilter);
        });
        Exception nullImageNameResult = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.applyFilter(imageWithNullName, validFilter);
        });
        Exception blankImageNameResult = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.applyFilter(imageWithBlankName, validFilter);
        });
        Exception nullImageExtensionResult = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.applyFilter(imageWithNullExtension, validFilter);
        });
        Exception blankImageExtensionResult = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.applyFilter(imageWithBlankExtension, validFilter);
        });
        Exception nullFilterResult = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.applyFilter(validImage, null);
        });


        //then
        assertEquals(nullImageExpectedMessage, nullImageResult.getMessage());
        assertEquals(invalidNameOrExtensionExpectedMessage, nullImageNameResult.getMessage());
        assertEquals(invalidNameOrExtensionExpectedMessage, blankImageNameResult.getMessage());
        assertEquals(invalidNameOrExtensionExpectedMessage, nullImageExtensionResult.getMessage());
        assertEquals(invalidNameOrExtensionExpectedMessage, blankImageExtensionResult.getMessage());
        assertEquals(nullFilterExpectedMessage, nullFilterResult.getMessage());
    }

    @Test
    void testCombineFiltersValidFilterReturnsCombinedFilter() {
        //given
        var originalImage = new Image("image", ".png", "Yet another selfie");

        Function<Image, Image> saturationFilter = (image) -> filterProcessor.filtering(image,
                "_saturated",
                " with saturation filter applied");
        Function<Image, Image> blurFilter = (image) -> filterProcessor.filtering(image,
                "_blurred",
                " with blur filter applied");
        Function<Image, Image> expectedFilter = (image) -> filterProcessor.filtering(image,
                "_saturated_blurred",
                " with saturation filter applied with blur filter applied");

        var imageWithExpectedFilter = filterProcessor.applyFilter(originalImage, expectedFilter);


        //when
        var actualFilter = filterProcessor.combineFilters(saturationFilter, blurFilter);
        var imageWithActualFilter = filterProcessor.applyFilter(originalImage, actualFilter);


        //then
        assertNotNull(actualFilter);
        assertEquals(imageWithExpectedFilter, imageWithActualFilter);
    }

    @Test
    void testCombineFiltersInvalidFilterThrowsException() {
        //given
        var originalImage = new Image("image", ".png", "Yet another selfie");

        Function<Image, Image> validFilter = (image) -> filterProcessor.filtering(image,
                "_saturated",
                " with saturation filter applied");

        var nullFilterExpectedMessage = "Both filters must have non-null values!";


        //when
        Exception firstNullFilterException = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.combineFilters(null, validFilter);
        });
        Exception secondNullFilterException = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.combineFilters(validFilter, null);
        });
        Exception bothNullFiltersException = assertThrows(IllegalArgumentException.class, () -> {
            filterProcessor.combineFilters(null, null);
        });


        //then
        assertEquals(nullFilterExpectedMessage, firstNullFilterException.getMessage());
        assertEquals(nullFilterExpectedMessage, secondNullFilterException.getMessage());
        assertEquals(nullFilterExpectedMessage, bothNullFiltersException.getMessage());
    }
}