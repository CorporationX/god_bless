package faang.school.godbless.sprint.two.instagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileProcessorTest {
    private FilterProcessor filterProcessor;
    private Image originalImage;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;
    private Function<Image, Image> vignetteFilter;

    @BeforeEach
    void setUp() {
        originalImage = new Image("original.jpg", "Original image");
        filterProcessor = new FilterProcessor();
        grayscaleFilter = (image) -> new Image(image.getFileName() + "_grayscale", "Filter: grayscale");
        sepiaFilter = (image) -> new Image(image.getFileName() + "_sepia", "Filter: sepia");
        vignetteFilter = (image) -> new Image(image.getFileName() + "_vignette", "Filter: vignette");
    }

    @Test
    void testApplyFilter_normalTest() {
        Image grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        Image sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        assertTrue(grayscaleImage.getFileName().equals("original.jpg_grayscale"));
        assertTrue(sepiaImage.getFileName().equals("original.jpg_sepia"));
        assertTrue(vignetteImage.getFileName().equals("original.jpg_vignette"));
    }

    @Test
    void testCombineFilters_normalTest() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertTrue(combinedImage.getFileName().equals("original.jpg_grayscale_sepia"));
    }

}
