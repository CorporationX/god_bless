package faang.school.godbless.lambda_stream.instagram_filters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    Image originalImage;
    FilterProcessor filterProcessor = new FilterProcessor();
    Function<Image, Image> grayscaleFilter;
    Function<Image, Image> sepiaFilter;
    Function<Image, Image> vignetteFilter;

    @BeforeEach
    void setUp() {
        originalImage = new Image("photo", "No filters");
        grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");
        vignetteFilter = (image) -> new Image(
                image.getName() + "_vignette",
                image.getDescription() + " виньетка");
    }

    @Test
    void testApplyFilter() {
        Image newImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        assertTrue(newImage.getName().contains("grayscale"));
        assertTrue(newImage.getDescription().contains("Фильтр: черно-белый"));
    }

    @Test
    void testCombineFilters() {
        Function<Image, Image> sepiaAndVignette = filterProcessor.combineFilters(sepiaFilter, vignetteFilter);
        Image newImage = filterProcessor.applyFilter(originalImage, sepiaAndVignette);
        assertTrue(newImage.getName().contains("sepia_vignette"));
        assertTrue(newImage.getDescription().contains("Фильтр: сепия виньетка"));
    }
}