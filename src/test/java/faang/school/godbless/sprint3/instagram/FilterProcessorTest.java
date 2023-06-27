package faang.school.godbless.sprint3.instagram;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterProcessorTest {
    private static Image originalImage = new Image("original", "Original Image");

    @Test
    public void testGrayscaleFilter() {
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Grayscale Filter");
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        assertEquals("original_grayscale", grayscaleImage.getName());
        assertEquals("Grayscale Filter", grayscaleImage.getDescription());
    }

    @Test
    public void testSepiaFilter() {
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Sepia Filter");
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        assertEquals("original_sepia", sepiaImage.getName());
        assertEquals("Sepia Filter", sepiaImage.getDescription());
    }

    @Test
    public void testVignetteFilter() {
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> vignetteFilter = (image) -> new Image(image.getName() + "_vignette", "Vignette Filter");
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);
        assertEquals("original_vignette", vignetteImage.getName());
        assertEquals("Vignette Filter", vignetteImage.getDescription());
    }

    @Test
    public void testCombinedFilter() {
        FilterProcessor filterProcessor = new FilterProcessor();
        Function<Image, Image> grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Grayscale Filter");
        Function<Image, Image> sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Sepia Filter");

        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertEquals("original_grayscale_sepia", combinedImage.getName());
        assertEquals("Sepia Filter", combinedImage.getDescription());
    }
}
