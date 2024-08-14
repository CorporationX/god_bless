package faang.school.godbless.javalambda.task3.test;

import faang.school.godbless.javalambda.task3.FilterProcessor;
import faang.school.godbless.javalambda.task3.Image;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    Image originalImage;
    FilterProcessor filterProcessor;
    Image grayscaleImage;
    Image sepiaImage;
    Function<Image, Image> grayscaleFilter;
    Function<Image, Image> sepiaFilter;

    @BeforeEach
    void setUp() {
        originalImage = new Image("original.jpg", "Оригинальное изображение");
        filterProcessor = new FilterProcessor();
        grayscaleFilter = (image) -> new Image(image.getName() + "_grayscale", "Фильтр: черно-белый");
        sepiaFilter = (image) -> new Image(image.getName() + "_sepia", "Фильтр: сепия");

        grayscaleImage = filterProcessor.applyFilter(originalImage, grayscaleFilter);
        sepiaImage = filterProcessor.applyFilter(originalImage, sepiaFilter);
    }

    @Test
    void applyFilter_shouldApplyFilterCorrectly() {
        Function<Image, Image> vignetteFilter = (image) ->
                new Image(image.getName() + "_vignette", "Фильтр: виньетка");
        Image vignetteImage = filterProcessor.applyFilter(originalImage, vignetteFilter);

        assertEquals("original.jpg_grayscale", grayscaleImage.getName());
        assertEquals("Фильтр: черно-белый", grayscaleImage.getDescription());

        assertEquals("original.jpg_sepia", sepiaImage.getName());
        assertEquals("Фильтр: сепия", sepiaImage.getDescription());

        assertEquals("original.jpg_vignette", vignetteImage.getName());
        assertEquals("Фильтр: виньетка", vignetteImage.getDescription());
    }

    @Test
    void combineFilters_shouldApplyFiltersSequentially() {
        Function<Image, Image> combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(originalImage, combinedFilter);

        assertEquals("original.jpg_grayscale_sepia", combinedImage.getName());
        assertEquals("Фильтр: сепия", combinedImage.getDescription());
    }
}