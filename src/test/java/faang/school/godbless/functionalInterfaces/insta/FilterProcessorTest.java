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

        Function<Image, Image> inverseFilter = (image) -> {
            var newName = image.fileName() + "_inverse";
            var newDescription = image.description() + " with inverse filter on";

            return new Image(newName, image.fileExtension(), newDescription);
        };

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

        Function<Image, Image> validFilter = (image) -> {
            var newName = image.fileName() + "_inverse";
            var newDescription = image.description() + " with inverse filter on";

            return new Image(newName, image.fileExtension(), newDescription);
        };

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

        Function<Image, Image> saturationFilter = (image) -> {
            var newName = image.fileName() + "_saturated";
            var newDescription = image.description() + " with saturation filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };
        Function<Image, Image> blurFilter = (image) -> {
            var newName = image.fileName() + "_blurred";
            var newDescription = image.description() + " with blur filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };

        Function<Image, Image> expectedFilter = (image) -> {
            var newName = image.fileName() + "_saturated_blurred";
            var newDescription = image.description() + " with saturation filter applied with blur filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };

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

        Function<Image, Image> validFilter = (image) -> {
            var newName = image.fileName() + "_saturated";
            var newDescription = image.description() + " with saturation filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };

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