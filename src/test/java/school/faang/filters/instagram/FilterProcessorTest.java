package school.faang.filters.instagram;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilterProcessorTest {
    private Image originalImage;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;

    @BeforeEach
    public void setUp() {
        originalImage = new Image("original.jpg", "Оригинальное изображение");
        grayscaleFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        sepiaFilter = (image) -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");
    }

    @Test
    void applyGrayscaleFilterTest() {
        Image expected = new Image("original.jpg", "Оригинальное изображение | Фильтр: черно-белый");
        Image actual = FilterProcessor.applyFilter(originalImage, grayscaleFilter);
        assertEquals(expected, actual);
    }

    @Test
    void applySepiaFilterTest() {
        Image expected = new Image("original.jpg", "Оригинальное изображение | Фильтр: сепия");
        Image actual = FilterProcessor.applyFilter(originalImage, sepiaFilter);
        assertEquals(expected, actual);
    }

    @Test
    void applyCombinedFilterTest() {
        Image expected = new Image("original.jpg", "Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия");
        Image actual = FilterProcessor.combineFilters(originalImage, grayscaleFilter, sepiaFilter);
        assertEquals(expected, actual);
    }
}
