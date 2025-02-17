package school.faang.instagram_filters.BJS2_57744;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {

    private FilterProcessor filterProcessor;
    private Image luna;
    private Function<Image, Image> grayscaleFilter;
    private Function<Image, Image> sepiaFilter;

    @BeforeEach
    void setUp() {
        filterProcessor = new FilterProcessor();
        luna = new Image("Luna.jpg", "Full moon in the sky");
        grayscaleFilter = (image) -> new Image(
                image.getName(), image.getDescription() + " | Фильтр: черно-белый");
        sepiaFilter = (image) -> new Image(
                image.getName(), image.getDescription() + " | Фильтр: сепия");
    }

    @Test
    void testApplyFilter() {
        Image lunaFiltered = filterProcessor.applyFilter(luna, grayscaleFilter);

        assertEquals(
                "Full moon in the sky | Фильтр: черно-белый",
                lunaFiltered.getDescription());
    }

    @Test
    void testCombineFilters() {
        var combinedFilter = filterProcessor.combineFilters(grayscaleFilter, sepiaFilter);
        Image combinedImage = filterProcessor.applyFilter(luna, combinedFilter);

        assertEquals(
                "Full moon in the sky | Фильтр: черно-белый | Фильтр: сепия",
                combinedImage.getDescription());
    }
}