package school.faang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FilterProcessorTest {
    Image testImage;
    FilterProcessor sut;

    @BeforeEach
    void setUp() {
        testImage = new Image("original.jpg", "Оригинальное изображение");
        sut = new FilterProcessor();
    }

    @Test
    void applyFilter() {
        // Arrange
        Function<Image, Image> filter = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        String expectedName = testImage.name();
        String expectedDescription = "Оригинальное изображение | Фильтр: черно-белый";

        // Act
        Image filteredImage = sut.applyFilter(testImage, filter);

        // Assert
        Assertions.assertEquals(expectedName, filteredImage.name());
        Assertions.assertEquals(expectedDescription, filteredImage.description());
    }

    @Test
    void combineFilters() {
        // Arrange
        Function<Image, Image> filter1 = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: черно-белый");
        Function<Image, Image> filter2 = (image) ->
                new Image(image.name(), image.description() + " | Фильтр: сепия");
        String expectedName = testImage.name();
        String expectedDescription = "Оригинальное изображение | Фильтр: черно-белый | Фильтр: сепия";

        // Act
        Function<Image, Image> combinedFilter = sut.combineFilters(filter1, filter2);
        Image combinedImage = sut.applyFilter(testImage, combinedFilter);

        // Assert
        Assertions.assertEquals(expectedName, combinedImage.name());
        Assertions.assertEquals(expectedDescription, combinedImage.description());
    }
}