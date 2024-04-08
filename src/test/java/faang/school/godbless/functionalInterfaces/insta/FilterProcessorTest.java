package faang.school.godbless.functionalInterfaces.insta;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    FilterProcessor filterProcessor = new FilterProcessor();

    @Test
    void testApplyFilter_validParams_appliesFilter() {
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
    void testApplyFilter_invalidParams_throwsException() {
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
        Throwable nullImageResult = assertThrows(NullPointerException.class, () -> {
            filterProcessor.applyFilter(null, validFilter);
        });
        Throwable nullImageNameResult = assertThrows(NullPointerException.class, () -> {
            filterProcessor.applyFilter(imageWithNullName, validFilter);
        });
        Throwable blankImageNameResult = assertThrows(NullPointerException.class, () -> {
            filterProcessor.applyFilter(imageWithBlankName, validFilter);
        });
        Throwable nullImageExtensionResult = assertThrows(NullPointerException.class, () -> {
            filterProcessor.applyFilter(imageWithNullExtension, validFilter);
        });
        Throwable blankImageExtensionResult = assertThrows(NullPointerException.class, () -> {
            filterProcessor.applyFilter(imageWithBlankExtension, validFilter);
        });
        Throwable nullFilterResult = assertThrows(NullPointerException.class, () -> {
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
    void testCombineFilters_validFilter_returnsCombinedFilter() {
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
    void testCombineFilters_invalidFilter_throwsException() {
        //given
        var originalImage = new Image("image", ".png", "Yet another selfie");

        Function<Image, Image> validFilter = (image) -> {
            var newName = image.fileName() + "_saturated";
            var newDescription = image.description() + " with saturation filter applied";

            return new Image(newName, image.fileExtension(), newDescription);
        };

        var nullFilterExpectedMessage = "Both filters must have non-null values!";


        //when
        Throwable firstNullFilterException = assertThrows(NullPointerException.class, () -> {
            filterProcessor.combineFilters(null, validFilter);
        });
        Throwable secondNullFilterException = assertThrows(NullPointerException.class, () -> {
            filterProcessor.combineFilters(validFilter, null);
        });
        Throwable bothNullFiltersException = assertThrows(NullPointerException.class, () -> {
            filterProcessor.combineFilters(null, null);
        });


        //then
        assertEquals(nullFilterExpectedMessage, firstNullFilterException.getMessage());
        assertEquals(nullFilterExpectedMessage, secondNullFilterException.getMessage());
        assertEquals(nullFilterExpectedMessage, bothNullFiltersException.getMessage());
    }
}