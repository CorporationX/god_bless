package dima.evseenko.instagram;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {

    @Test
    void applyFilter() {
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");

        Image image = new Image("Image", "Default image");

        FilterProcessor filterProcessor = new FilterProcessor();
        image = filterProcessor.applyFilter(image, vignetteFilter);

        assertTrue(image.getDescription().contains("Фильтр: виньетка"));
    }

    @Test
    void applyNullFilter() {
        Image image = new Image("Image", "Default image");

        FilterProcessor filterProcessor = new FilterProcessor();

        assertEquals(image, filterProcessor.applyFilter(image, null));
    }

    @Test
    void combineFilters() {
        Function<Image, Image> vignetteFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: виньетка");
        Function<Image, Image> sepiaFilter = image -> new Image(image.getName(), image.getDescription() + " | Фильтр: сепия");

        Image image = new Image("Image", "Default image");

        FilterProcessor filterProcessor = new FilterProcessor();
        image = filterProcessor.combineFilters(image, vignetteFilter, sepiaFilter);

        assertTrue(image.getDescription().contains("Фильтр: виньетка"));
        assertTrue(image.getDescription().contains("Фильтр: сепия"));
    }

    @Test
    void applyNullFilters() {
        Image image = new Image("Image", "Default image");

        FilterProcessor filterProcessor = new FilterProcessor();

        assertEquals(image, filterProcessor.combineFilters(image, (Function<Image, Image>) null));
    }
}