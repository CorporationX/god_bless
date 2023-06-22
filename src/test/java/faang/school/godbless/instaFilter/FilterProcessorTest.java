package faang.school.godbless.instaFilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    private FilterProcessor filterProcessor;
    private Function<Image, Image> filter;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;
    private Image originalImage;

    @BeforeEach
    void setUp() {
        originalImage = new Image("original.jpg", "Оригинальное изображение");
        filterProcessor = new FilterProcessor();

        grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Filter: grayscale");
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Filter: sepia");
    }

    @Test
    void shouldThrowExceptionForApplyFilter() {
        assertAll(
                () -> assertThrowsExactly(IllegalArgumentException.class,
                        () -> filterProcessor.applyFilter(null, grayscaleFilter)),
                () -> assertThrowsExactly(IllegalArgumentException.class,
                        () -> filterProcessor.applyFilter(originalImage, null))
        );
    }

    @Test
    void testCombineFilters() {
        String descriptionForGrayscale = " and " + "Filter: grayscale";
        String descriptionForSepia = " and " + "Filter: sepia";
        String expectedName = "original.jpg_grayscale_sepia";
        String expectedDescription = originalImage.getDescription() + descriptionForGrayscale + descriptionForSepia;

        grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale",
                image.getDescription() + descriptionForGrayscale);
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia",
                image.getDescription() + descriptionForSepia);

        filter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);

        Image result = filterProcessor.applyFilter(originalImage, filter);

        assertEquals(expectedName, result.getName());
        assertEquals(expectedDescription, result.getDescription());
    }

    @Test
    void testApplyFilter() {
        Image modifiedImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        assertEquals("original.jpg_grayscale", modifiedImage.getName());
        assertEquals("Filter: grayscale", modifiedImage.getDescription());

        modifiedImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        assertEquals("original.jpg_sepia", modifiedImage.getName());
        assertEquals("Filter: sepia", modifiedImage.getDescription());
    }
}