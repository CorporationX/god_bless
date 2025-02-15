package instagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.UnaryOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FilterProcessorTest {

    private static final String ORIGINAL_DESCRIPTION = "Original image";
    private static final String GRAYSCALE_FILTER = "Filter: Grayscale";
    private static final String SEPIA_FILTER = "Filter: Sepia";
    private static final String VIGNETTE_FILTER = "Filter: Vignette";

    private FilterProcessor filterProcessor;
    private Image originalImage;

    @BeforeEach
    void setUp() {
        filterProcessor = new FilterProcessor();
        originalImage = new Image("original.jpg", ORIGINAL_DESCRIPTION);
    }

    @Nested
    class ApplyFilterTests {

        @Test
        void testApplyGrayscaleFilter() {
            UnaryOperator<Image> grayscaleFilter = image ->
                    new Image(image.name(), image.description() + " | " + GRAYSCALE_FILTER);
            Image filteredImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
            assertEquals(ORIGINAL_DESCRIPTION + " | " + GRAYSCALE_FILTER, filteredImage.description());
            assertEquals("original.jpg", filteredImage.name());
        }

        @Test
        void testApplySepiaFilter() {
            UnaryOperator<Image> sepiaFilter = image ->
                    new Image(image.name(), image.description() + " | " + SEPIA_FILTER);
            Image filteredImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
            assertEquals(ORIGINAL_DESCRIPTION + " | " + SEPIA_FILTER, filteredImage.description());
            assertEquals("original.jpg", filteredImage.name());
        }

        @Test
        void testApplyMultipleFiltersSequentially() {
            UnaryOperator<Image> grayscaleFilter = image ->
                    new Image(image.name(), image.description() + " | " + GRAYSCALE_FILTER);
            UnaryOperator<Image> sepiaFilter = image ->
                    new Image(image.name(), image.description() + " | " + SEPIA_FILTER);
            Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
            Image sepiaImage = filterProcessor.applyFilter(grayscaleImage, sepiaFilter);
            String expectedDescription = ORIGINAL_DESCRIPTION + " | " + GRAYSCALE_FILTER + " | " + SEPIA_FILTER;
            assertEquals(expectedDescription, sepiaImage.description());
        }

        @Test
        void testApplyFilterNullFilter() {
            assertThrows(NullPointerException.class, () ->
                    filterProcessor.applyFilter(originalImage, (UnaryOperator<Image>) null)
            );
        }
    }

    @Nested
    class CombineFiltersTests {

        @Test
        void testCombineTwoFilters() {
            UnaryOperator<Image> grayscaleFilter = image ->
                    new Image(image.name(), image.description() + " | " + GRAYSCALE_FILTER);
            UnaryOperator<Image> sepiaFilter = image ->
                    new Image(image.name(), image.description() + " | " + SEPIA_FILTER);
            UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
            Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);
            String expectedDescription = ORIGINAL_DESCRIPTION + " | " + GRAYSCALE_FILTER + " | " + SEPIA_FILTER;
            assertEquals(expectedDescription, combinedImage.description());
        }

        @Test
        void testCombineThreeFilters() {
            UnaryOperator<Image> grayscaleFilter = image ->
                    new Image(image.name(), image.description() + " | " + GRAYSCALE_FILTER);
            UnaryOperator<Image> sepiaFilter = image ->
                    new Image(image.name(), image.description() + " | " + SEPIA_FILTER);
            UnaryOperator<Image> vignetteFilter = image ->
                    new Image(image.name(), image.description() + " | " + VIGNETTE_FILTER);
            UnaryOperator<Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
            UnaryOperator<Image> allCombined = filterProcessor.combineFilters(combinedFilter, vignetteFilter);
            Image filteredImage = filterProcessor.applyFilter(originalImage, allCombined);
            String expectedDescription = ORIGINAL_DESCRIPTION + " | "
                    + GRAYSCALE_FILTER + " | " + SEPIA_FILTER + " | " + VIGNETTE_FILTER;
            assertEquals(expectedDescription, filteredImage.description());
        }

        @Test
        void testCombineIdentityFilter() {
            UnaryOperator<Image> identityFilter = UnaryOperator.identity();
            UnaryOperator<Image> combined = filterProcessor.combineFilters(identityFilter, identityFilter);
            Image filteredImage = filterProcessor.applyFilter(originalImage, combined);
            assertEquals(originalImage.description(), filteredImage.description());
            assertEquals(originalImage.name(), filteredImage.name());
        }

        @Test
        void testCombineFiltersNullArguments() {
            UnaryOperator<Image> identityFilter = UnaryOperator.identity();
            assertThrows(NullPointerException.class, () ->
                    filterProcessor.combineFilters(null, identityFilter)
            );
            assertThrows(NullPointerException.class, () ->
                    filterProcessor.combineFilters(identityFilter, null)
            );
        }
    }
}
